package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseTableNumGetDTO;
import com.DevTino.festino_admin.order.service.TableNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<ApiResponse<Object>> getTableNum(@PathVariable(value = "boothId") UUID boothId){

        List<ResponseTableNumGetDTO> responseTableNumGetDTOList = tableNumService.getTableNum(boothId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "테이블 번호 조회 성공", responseTableNumGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Object>> saveTableNum(@RequestBody RequestTableNumSaveDTO requestTableNumSaveDTO){

        UUID boothId = tableNumService.saveTableNum(requestTableNumSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "테이블 번호 저장 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
