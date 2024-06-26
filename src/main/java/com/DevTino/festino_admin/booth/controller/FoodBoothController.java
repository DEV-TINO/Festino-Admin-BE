package com.DevTino.festino_admin.booth.controller;

import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothSaveDTO;
import com.DevTino.festino_admin.booth.service.FoodBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class FoodBoothController {
    FoodBoothService foodBoothService;

    @Autowired
    public FoodBoothController(FoodBoothService foodBoothService) {
        this.foodBoothService = foodBoothService;
    }

    // 푸드트럭 등록
    @PostMapping("/booth/food")
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
}
