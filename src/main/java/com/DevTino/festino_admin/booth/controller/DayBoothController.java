package com.DevTino.festino_admin.booth.controller;


import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothGetDTO;
import com.DevTino.festino_admin.booth.service.DayBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/booth/day")
public class DayBoothController {
    DayBoothService dayBoothService;

    @Autowired
    public DayBoothController(DayBoothService dayBoothService) {
        this.dayBoothService = dayBoothService;
    }

    // 주간부스 등록
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveDayBooth(@RequestBody RequestDayBoothSaveDTO requestDayBoothSaveDTO) {

        // 주간부스 등록 service
        UUID boothId = dayBoothService.saveDayBooth(requestDayBoothSaveDTO);

        // 주간부스 등록 성공 여부
        boolean success = boothId != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주간부스 등록 성공" : "주간부스 등록 시 DAO 저장 실패");
        requestMap.put("boothId", boothId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 주간부스 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateDayBooth(@RequestBody RequestDayBoothUpdateDTO requestDayBoothUpdateDTO) {

        // 주간부스 수정 service
        UUID boothId = dayBoothService.updateDayBooth(requestDayBoothUpdateDTO);

        // 주간부스 수정 성공 여부
        boolean success = boothId != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주간부스 수정 성공" : "주간부스 수정 시 DAO 저장 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 주간부스 조회
    @GetMapping("/{boothId}")
    public ResponseEntity<Map<String, Object>> getDayBooth(@PathVariable("boothId") UUID boothId) {

        // 주간부스 조회 service
        ResponseDayBoothGetDTO responseDayBoothGetDTO = dayBoothService.getDayBooth(boothId);

        // 주간부스 조회 성공 여부
        boolean success = responseDayBoothGetDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주간부스 조회 성공" : "주간부스 조회 시 DAO 검색 실패");
        requestMap.put("boothInfo", responseDayBoothGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
