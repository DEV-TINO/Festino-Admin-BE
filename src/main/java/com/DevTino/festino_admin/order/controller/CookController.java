package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<ApiResponse<Object>> updateCookFinish(@PathVariable("boothId") UUID boothId, @RequestBody RequestCookFinishUpdateDTO requestCookFinishUpdateDTO){

        // Cook 조리 완료 service 실행
        ResponseCookFinishUpdateDTO responseCookFinishUpdateDTO = cookService.updateCookFinish(boothId, requestCookFinishUpdateDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "Cook 조리 완료 성공", responseCookFinishUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 서빙 수량 변경
    @PutMapping("/count")
    public ResponseEntity<ApiResponse<Object>> updateCookCount(@PathVariable("boothId") UUID boothId, @RequestBody RequestCookCountUpdateDTO requestCookCountUpdateDTO){

        // 서빙 수량 변경 service 실행
        ResponseCookCountUpdateDTO responseCookCountUpdateDTO = cookService.updateCookCount(boothId, requestCookCountUpdateDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "서빙 수량 변경 성공", responseCookCountUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
