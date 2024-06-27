package com.DevTino.festino_admin.booth.controller;

import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothUpdateDTO;
import com.DevTino.festino_admin.booth.service.NightBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class NightBoothController {
    NightBoothService nightBoothService;

    @Autowired
    public NightBoothController(NightBoothService nightBoothService) {
        this.nightBoothService = nightBoothService;
    }

    // 야간부스 등록
    @PostMapping("/booth/night")
    public ResponseEntity<Map<String, Object>> saveNightBooth(@RequestBody RequestNightBoothSaveDTO requestNightBoothSaveDTO) {

        // 야간부스 등록 service
        UUID boothId = nightBoothService.saveNightBooth(requestNightBoothSaveDTO);

        // 야간부스 등록 성공 여부
        boolean success = boothId != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 등록 성공" : "야간부스 등록 시 DAO 저장 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 야간부스 수정
    @PutMapping("/booth/night")
    public ResponseEntity<Map<String, Object>> updateNightBooth(@RequestBody RequestNightBoothUpdateDTO requestNightBoothUpdateDTO) {

        // 야간부스 수정 service
        UUID boothId = nightBoothService.updateNightBooth(requestNightBoothUpdateDTO);

        // 야간부스 수정 성공 여부
        boolean success = boothId != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 수정 성공" : "야간부스 수정 시 DAO 저장 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
