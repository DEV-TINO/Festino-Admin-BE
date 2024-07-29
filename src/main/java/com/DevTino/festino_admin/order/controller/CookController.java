package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.order.domain.DTO.RequestCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/booth/{boothId}/order/cook")
public class CookController {

    CookService cookService;

    @Autowired
    public CookController(CookService cookService){
        this.cookService = cookService;
    }



    // Cook 조리 완료
    @PutMapping("/finish")
    public ResponseEntity<Map<String, Object>> updateCookFinish(@RequestBody RequestCookFinishUpdateDTO requestCookFinishUpdateDTO){

        // Cook 조리 완료 service 실행
        ResponseCookFinishUpdateDTO responseCookFinishUpdateDTO = cookService.updateCookFinish(requestCookFinishUpdateDTO);

        // Cook 조리 완료 성공 여부 설정
        boolean success = (responseCookFinishUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "Cook 조리 완료 성공" : "Cook 조리 완료 시 DAO 검색 실패");
        requestMap.put("finishInfo", responseCookFinishUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 서빙 수량 변경
    @PutMapping("/count")
    public ResponseEntity<Map<String, Object>> updateCookCount(@RequestBody RequestCookCountUpdateDTO requestCookCountUpdateDTO){

        // 서빙 수량 변경 service 실행
        ResponseCookCountUpdateDTO responseCookCountUpdateDTO = cookService.updateCookCount(requestCookCountUpdateDTO);

        // 서빙 수량 변경 성공 여부 설정
        boolean success = (responseCookCountUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "서빙 수량 변경 성공" : "서빙 수량 변경 시 DAO 검색 실패 또는 부적절한 servedCount 값");
        requestMap.put("countInfo", responseCookCountUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
