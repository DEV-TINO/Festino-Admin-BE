package com.DevTino.festino_admin.reservation.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.reservation.domain.DTO.*;
import com.DevTino.festino_admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
// @CrossOrigin("*")
@RequestMapping("/admin/reservation")
public class ReservationController {
    ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 예약 전체조회
    @GetMapping("/{type}/booth/{boothId}")
    public ResponseEntity<ApiResponse<Object>> getReservationAll(@PathVariable("boothId") UUID boothId, @PathVariable("type") String type) {

        // 예약 전체조회 service
        ResponseReservationsGetDTO responseReservationsGetDTOList = reservationService.getReservationAll(boothId, type);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "예약 전체조회 성공", responseReservationsGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 예약 삭제
    @DeleteMapping
    public ResponseEntity<ApiResponse<Object>> deleteReservation(@RequestBody RequestReservationDeleteDTO requestReservationDeleteDTO) throws IOException {

        // 예약 삭제 service
        ResponseReservationDeleteDTO responseReservationDeleteDTO = reservationService.deleteReservation(requestReservationDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "예약 삭제 성공", responseReservationDeleteDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 예약 완료
    @PutMapping("/complete")
    public ResponseEntity<ApiResponse<Object>> completeReservation(@RequestBody RequestReservationCompleteUpdateDTO requestReservationCompleteUpdateDTO) throws IOException {

        // 예약 완료 service
        ResponseReservationCompleteUpdateDTO responseReservationCompleteUpdateDTO = reservationService.completeReservation(requestReservationCompleteUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "예약 완료 성공", responseReservationCompleteUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 예약 복구
    @PutMapping("/restore")
    public ResponseEntity<ApiResponse<Object>> restoreReservation(@RequestBody RequestReservationRestoreUpdateDTO requestReservationRestoreUpdateDTO) throws IOException {

        // 예약 복구 service
        ResponseReservationRestoreUpdateDTO responseReservationRestoreUpdateDTO = reservationService.restoreReservation(requestReservationRestoreUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "예약 복구 성공", responseReservationRestoreUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 예약 가능여부 수정
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateReservation(@RequestBody RequestReservationUpdateDTO requestReservationUpdateDTO) {

        // 예약 가능여부 수정 service
        ResponseReservationUpdateDTO responseReservationUpdateDTO = reservationService.updateReservation(requestReservationUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "예약 가능여부 수정 성공", responseReservationUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
