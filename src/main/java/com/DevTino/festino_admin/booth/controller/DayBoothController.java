package com.DevTino.festino_admin.booth.controller;


import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.service.DayBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
// @CrossOrigin("*")
@RequestMapping("/admin/booth/day")
public class DayBoothController {
    DayBoothService dayBoothService;

    @Autowired
    public DayBoothController(DayBoothService dayBoothService) {
        this.dayBoothService = dayBoothService;
    }

    // 주간부스 등록
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> saveDayBooth(@RequestBody RequestDayBoothSaveDTO requestDayBoothSaveDTO) {

        // 주간부스 등록 service
        UUID boothId = dayBoothService.saveDayBooth(requestDayBoothSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주간부스 등록 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    // 주간부스 수정
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateDayBooth(@RequestBody RequestDayBoothUpdateDTO requestDayBoothUpdateDTO) {

        // 주간부스 수정 service
        UUID boothId = dayBoothService.updateDayBooth(requestDayBoothUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주간부스 수정 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    // 주간부스 운영 중 여부 수정
    @PutMapping("/open")
    public ResponseEntity<ApiResponse<Object>> updateDayBoothOpen(@RequestBody RequestDayBoothOpenUpdateDTO requestDayBoothOpenUpdateDTO) {

        // 주간부스 운영 중 여부 수정 service
        ResponseDayBoothOpenUpdateDTO responseDayBoothOpenUpdateDTO = dayBoothService.updateDayBoothOpen(requestDayBoothOpenUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주간부스 운영 중 여부 수정 성공", responseDayBoothOpenUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    // 주간부스 조회
    @GetMapping("/{boothId}")
    public ResponseEntity<ApiResponse<Object>> getDayBooth(@PathVariable("boothId") UUID boothId) {

        // 주간부스 조회 service
        ResponseDayBoothGetDTO responseDayBoothGetDTO = dayBoothService.getDayBooth(boothId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주간부스 조회 성공", responseDayBoothGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    // 주간부스 전체조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getDayBoothAll() {

        // 주간부스 전체조회 service
        List<ResponseDayBoothsGetDTO> responseDayBoothsGetDTOList = dayBoothService.getDayBoothAll();

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주간부스 전체조회 성공", responseDayBoothsGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
