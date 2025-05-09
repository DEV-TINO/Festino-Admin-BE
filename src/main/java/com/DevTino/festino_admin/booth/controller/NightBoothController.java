package com.DevTino.festino_admin.booth.controller;

import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.service.NightBoothService;
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
@RequestMapping("/admin/booth/night")
public class NightBoothController {
    NightBoothService nightBoothService;

    @Autowired
    public NightBoothController(NightBoothService nightBoothService) {
        this.nightBoothService = nightBoothService;
    }

    // 야간부스 등록
    @PostMapping
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
    @PutMapping
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

    // 야간부스 운영 중 여부 수정
    @PutMapping("/open")
    public ResponseEntity<Map<String, Object>> updateNightBoothOpen(@RequestBody RequestNightBoothOpenUpdateDTO requestNightBoothOpenUpdateDTO) {

        // 야간부스 운영 중 여부 service
        ResponseNightBoothOpenUpdateDTO responseNightBoothOpenUpdateDTO = nightBoothService.updateNightBoothOpen(requestNightBoothOpenUpdateDTO);

        // 야간부스 운영 중 여부 수정 성공 여부
        boolean success = responseNightBoothOpenUpdateDTO != null;

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 운영 중 여부 수정 성공" : "야간부스 운영 중 여부 수정 시 DAO 저장 실패");
        requestMap.put("openInfo", responseNightBoothOpenUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 야간부스 주문가능 여부 수정
    @PutMapping("/order")
    public ResponseEntity<Map<String, Object>> updateNightBoothOrder(@RequestBody RequestNightBoothOrderUpdateDTO requestNightBoothOrderUpdateDTO) {

        // 야간부스 주문가능 여부 수정 service
        ResponseNightBoothOrderUpdateDTO responseNightBoothOrderUpdateDTO = nightBoothService.updateNightBoothOrder(requestNightBoothOrderUpdateDTO);

        // 야간부스 주문가능 여부 수정 성공 여부
        boolean success = responseNightBoothOrderUpdateDTO != null;

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 주문가능 여부 수정 성공" : "야간부스 주문가능 여부 수정 시 DAO 저장 실패");
        requestMap.put("orderInfo", responseNightBoothOrderUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 야간부스 예약가능 여부 수정
    @PutMapping("/reservation")
    public ResponseEntity<Map<String, Object>> updateNightBoothReservation(@RequestBody RequestNightBoothReservationUpdateDTO requestNightBoothReservationUpdateDTO) {

        // 야간부스 예약가능 여부 수정 service
        ResponseNightBoothReservationUpdateDTO responseNightBoothReservationUpdateDTO = nightBoothService.updateNightBoothReservation(requestNightBoothReservationUpdateDTO);

        // 야간부스 예약가능 여부 수정 성공 여부
        boolean success = responseNightBoothReservationUpdateDTO != null;

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 예약가능 여부 수정 성공" : "야간부스 예약가능 여부 수정 시 DAO 저장 실패");
        requestMap.put("reservationInfo", responseNightBoothReservationUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 토스페이 가능 여부 수정
    @PutMapping("/toss")
    public ResponseEntity<Map<String, Object>> updateNightBoothTossPay(@RequestBody RequestNightBoothTossPayUpdateDTO requestNightBoothTossPayUpdateDTO) {

        // 야간부스 토스페이 가능 여부 수정 service
        ResponseNightBoothTossPayUpdateDTO responseNightBoothTossPayUpdateDTO = nightBoothService.updateNightBoothTossPay(requestNightBoothTossPayUpdateDTO);

        // 야간부스 토스페이 가능 여부 수정 성공 여부
        boolean success = responseNightBoothTossPayUpdateDTO != null;

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 토스페이 가능 여부 수정 성공" : "야간부스 토스페이 가능 여부 수정 시 DAO 저장 실패");
        requestMap.put("tossPayInfo", responseNightBoothTossPayUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 카카오페이 가능 여부 수정
    @PutMapping("/kakao")
    public ResponseEntity<Map<String, Object>> updateNightBoothKakaoPay(@RequestBody RequestNightBoothKakaoPayUpdateDTO requestNightBoothKakaoPayUpdateDTO) {

        // 야간부스 카카오페이 가능 여부 수정 service
        ResponseNightBoothKakaoPayUpdateDTO responseNightBoothKakaoPayUpdateDTO = nightBoothService.updateNightBoothKakaoPay(requestNightBoothKakaoPayUpdateDTO);

        // 야간부스 카카오페이 가능 여부 수정 성공 여부
        boolean success = responseNightBoothKakaoPayUpdateDTO != null;

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 카카오페이 가능 여부 수정 성공" : "야간부스 카카오페이 가능 여부 수정 시 DAO 저장 실패");
        requestMap.put("kakaoPayInfo", responseNightBoothKakaoPayUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 야간부스 조회
    @GetMapping("/{boothId}")
    public ResponseEntity<Map<String, Object>> getNightBooth(@PathVariable("boothId") UUID boothId) {

        // 야간부스 조회 service
        ResponseNightBoothGetDTO responseNightBoothGetDTO = nightBoothService.getNightBooth(boothId);

        // 야간부스 조회 성공 여부
        boolean success = responseNightBoothGetDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 조회 성공" : "야간부스 조회 시 DAO 검색 실패");
        requestMap.put("boothInfo", responseNightBoothGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getNightBoothAll() {

        // 야간부스 전체조회 service
        List<ResponseNightBoothsGetDTO> responseNightBoothsGetDTO = nightBoothService.getNightBoothAll();

        // 야간부스 전체조회 성공 여부
        boolean success = responseNightBoothsGetDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "야간부스 전체조회 성공" : "야간부스 전체조회 시 DAO 검색 실패");
        requestMap.put("boothList", responseNightBoothsGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
