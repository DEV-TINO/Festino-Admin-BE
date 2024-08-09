package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseTableNumGetDTO;
import com.DevTino.festino_admin.order.service.TableNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/order/table")
public class TableNumController {

    TableNumService tableNumService;

    @Autowired
    public TableNumController(TableNumService tableNumService) {
        this.tableNumService = tableNumService;
    }

    @GetMapping("/booth/{boothId}")
    public ResponseEntity<Map<String, Object>> getTableNum(@PathVariable(value = "boothId") UUID boothId){

        List<ResponseTableNumGetDTO> responseTableNumGetDTOList = tableNumService.getTableNum(boothId);

        boolean success = boothId != null;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "테이블 번호 조회 성공" : "테이블 번호 조회 실패");
        requestMap.put("tableNumList", responseTableNumGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveTableNum(@RequestBody RequestTableNumSaveDTO requestTableNumSaveDTO){

        UUID boothId = tableNumService.saveTableNum(requestTableNumSaveDTO);

        boolean success = boothId != null;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "테이블 번호 저장 성공" : "테이블 번호 저장 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
