package com.DevTino.festino_admin.booth.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.service.FoodBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
// @CrossOrigin("*")
@RequestMapping("/admin/booth/food")
public class FoodBoothController {
    FoodBoothService foodBoothService;

    @Autowired
    public FoodBoothController(FoodBoothService foodBoothService) {
        this.foodBoothService = foodBoothService;
    }

    // 푸드트럭 등록
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> saveFoodBooth(@RequestBody RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {

        // 푸드트럭 등록 service
        UUID boothId = foodBoothService.saveFoodBooth(requestFoodBoothSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "푸드트럭 등록 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 푸드트럭 수정
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateFoodBooth(@RequestBody RequestFoodBoothUpdateDTO requestFoodBoothUpdateDTO) {

        // 푸드트럭 수정 service
        UUID boothId = foodBoothService.updateFoodBooth(requestFoodBoothUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "푸드트럭 수정 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 푸드트럭 운영 중 여부 수정
    @PutMapping("/open")
    public ResponseEntity<ApiResponse<Object>> updateFoodBoothOpen(@RequestBody RequestFoodBoothOpenUpdateDTO requestFoodBoothOpenUpdateDTO) {

        // 푸드트럭 운영 중 여부 수정 service
        ResponseFoodBoothOpenUpdateDTO responseFoodBoothOpenUpdateDTO = foodBoothService.updateFoodBoothOpen(requestFoodBoothOpenUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "푸드트럭 운영 중 여부 수정 성공", responseFoodBoothOpenUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 푸드트럭 조회
    @GetMapping("/{boothId}")
    public ResponseEntity<ApiResponse<Object>> getFoodBooth(@PathVariable("boothId") UUID boothId) {

        // 푸드트럭 조회 service
        ResponseFoodBoothGetDTO responseFoodBoothGetDTO = foodBoothService.getFoodBooth(boothId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "푸드트럭 조회 성공", responseFoodBoothGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 푸드트럭 전체조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getFoodBoothAll() {

        // 푸드트럭 전체조회 service
        List<ResponseFoodBoothsGetDTO> responseFoodBoothsGetDTOList = foodBoothService.getFoodBoothAll();

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "푸드트럭 전체조회 성공", responseFoodBoothsGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
