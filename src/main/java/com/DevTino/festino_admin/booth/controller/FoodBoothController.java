package com.DevTino.festino_admin.booth.controller;

import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.service.FoodBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Map<String, Object>> saveFoodBooth(@RequestBody RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {

        // 푸드트럭 등록 service
        UUID boothId = foodBoothService.saveFoodBooth(requestFoodBoothSaveDTO);

        // 푸드트럭 등록 성공 여부
        boolean success = boothId != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "푸드트럭 등록 성공" : "푸드트럭 등록 시 DAO 저장 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 푸드트럭 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateFoodBooth(@RequestBody RequestFoodBoothUpdateDTO requestFoodBoothUpdateDTO) {

        // 푸드트럭 수정 service
        UUID boothId = foodBoothService.updateFoodBooth(requestFoodBoothUpdateDTO);

        // 푸드트럭 수정 성공 여부
        boolean success = boothId != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "푸드트럭 수정 성공" : "푸드트럭 수정 시 DAO 저장 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 푸드트럭 운영 중 여부 수정
    @PutMapping("/open")
    public ResponseEntity<Map<String, Object>> updateFoodBoothOpen(@RequestBody RequestFoodBoothOpenUpdateDTO requestFoodBoothOpenUpdateDTO) {

        // 푸드트럭 운영 중 여부 수정 service
        ResponseFoodBoothOpenUpdateDTO responseFoodBoothOpenUpdateDTO = foodBoothService.updateFoodBoothOpen(requestFoodBoothOpenUpdateDTO);

        // 푸드트럭 운영 중 여부 수정 성공 여부
        boolean success = responseFoodBoothOpenUpdateDTO != null;

        // Map을 통해 메시지와 info값 json 데이터로 변환
        Map<String , Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "푸드트럭 운영 중 여부 수정 성공" : "푸드트럭 운영 중 여부 수정 시 DAO 저장 실패");
        requestMap.put("openInfo", responseFoodBoothOpenUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 푸드트럭 조회
    @GetMapping("/{boothId}")
    public ResponseEntity<Map<String, Object>> getFoodBooth(@PathVariable("boothId") UUID boothId) {

        // 푸드트럭 조회 service
        ResponseFoodBoothGetDTO responseFoodBoothGetDTO = foodBoothService.getFoodBooth(boothId);

        // 푸드트럭 조회 성공 여부
        boolean success = responseFoodBoothGetDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "푸드트럭 조회 성공" : "푸드트럭 조회 시 DAO 검색 실패");
        requestMap.put("boothInfo", responseFoodBoothGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 푸드트럭 전체조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getFoodBoothAll() {

        // 푸드트럭 전체조회 service
        List<ResponseFoodBoothsGetDTO> responseFoodBoothsGetDTOList = foodBoothService.getFoodBoothAll();

        // 푸드트럭 전체조회 성공 여부
        boolean success = responseFoodBoothsGetDTOList != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "푸드트럭 전체조회 성공" : "푸드트럭 전체조회 시 DAO 검색 실패");
        requestMap.put("boothList", responseFoodBoothsGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
