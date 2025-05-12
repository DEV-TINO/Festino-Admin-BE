package com.DevTino.festino_admin.booth.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.service.NightBoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<ApiResponse<Object>> saveNightBooth(@RequestBody RequestNightBoothSaveDTO requestNightBoothSaveDTO) {

        // 야간부스 등록 service
        UUID boothId = nightBoothService.saveNightBooth(requestNightBoothSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 등록 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 야간부스 수정
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateNightBooth(@RequestBody RequestNightBoothUpdateDTO requestNightBoothUpdateDTO) {

        // 야간부스 수정 service
        UUID boothId = nightBoothService.updateNightBooth(requestNightBoothUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 수정 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 야간부스 운영 중 여부 수정
    @PutMapping("/open")
    public ResponseEntity<ApiResponse<Object>> updateNightBoothOpen(@RequestBody RequestNightBoothOpenUpdateDTO requestNightBoothOpenUpdateDTO) {

        // 야간부스 운영 중 여부 service
        ResponseNightBoothOpenUpdateDTO responseNightBoothOpenUpdateDTO = nightBoothService.updateNightBoothOpen(requestNightBoothOpenUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 운영 중 여부 수정 성공", responseNightBoothOpenUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 야간부스 주문가능 여부 수정
    @PutMapping("/order")
    public ResponseEntity<ApiResponse<Object>> updateNightBoothOrder(@RequestBody RequestNightBoothOrderUpdateDTO requestNightBoothOrderUpdateDTO) {

        // 야간부스 주문가능 여부 수정 service
        ResponseNightBoothOrderUpdateDTO responseNightBoothOrderUpdateDTO = nightBoothService.updateNightBoothOrder(requestNightBoothOrderUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 주문가능 여부 수정 성공", responseNightBoothOrderUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 야간부스 예약가능 여부 수정
    @PutMapping("/reservation")
    public ResponseEntity<ApiResponse<Object>> updateNightBoothReservation(@RequestBody RequestNightBoothReservationUpdateDTO requestNightBoothReservationUpdateDTO) {

        // 야간부스 예약가능 여부 수정 service
        ResponseNightBoothReservationUpdateDTO responseNightBoothReservationUpdateDTO = nightBoothService.updateNightBoothReservation(requestNightBoothReservationUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 예약가능 여부 수정 성공", responseNightBoothReservationUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 토스페이 가능 여부 수정
    @PutMapping("/toss")
    public ResponseEntity<ApiResponse<Object>> updateNightBoothTossPay(@RequestBody RequestNightBoothTossPayUpdateDTO requestNightBoothTossPayUpdateDTO) {

        // 야간부스 토스페이 가능 여부 수정 service
        ResponseNightBoothTossPayUpdateDTO responseNightBoothTossPayUpdateDTO = nightBoothService.updateNightBoothTossPay(requestNightBoothTossPayUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "토스페이 가능 여부 수정 성공", responseNightBoothTossPayUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 카카오페이 가능 여부 수정
    @PutMapping("/kakao")
    public ResponseEntity<ApiResponse<Object>> updateNightBoothKakaoPay(@RequestBody RequestNightBoothKakaoPayUpdateDTO requestNightBoothKakaoPayUpdateDTO) {

        // 야간부스 카카오페이 가능 여부 수정 service
        ResponseNightBoothKakaoPayUpdateDTO responseNightBoothKakaoPayUpdateDTO = nightBoothService.updateNightBoothKakaoPay(requestNightBoothKakaoPayUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "카카오페이 가능 여부 수정 성공", responseNightBoothKakaoPayUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 야간부스 조회
    @GetMapping("/{boothId}")
    public ResponseEntity<ApiResponse<Object>> getNightBooth(@PathVariable("boothId") UUID boothId) {

        // 야간부스 조회 service
        ResponseNightBoothGetDTO responseNightBoothGetDTO = nightBoothService.getNightBooth(boothId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 조회 성공", responseNightBoothGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 야간부스 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getNightBoothAll() {

        // 야간부스 전체조회 service
        List<ResponseNightBoothsGetDTO> responseNightBoothsGetDTO = nightBoothService.getNightBoothAll();

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "야간부스 전체 조회 성공", responseNightBoothsGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
