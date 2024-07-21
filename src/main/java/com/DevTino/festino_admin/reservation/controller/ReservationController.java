package com.DevTino.festino_admin.reservation.controller;

import com.DevTino.festino_admin.reservation.domain.DTO.*;
import com.DevTino.festino_admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<Map<String, Object>> getReservationAll(@PathVariable("boothId") UUID boothId, @PathVariable("type") String type) {

        // 예약 전체조회 service
        ResponseReservationsGetDTO responseReservationsGetDTOList = reservationService.getReservationAll(boothId, type);

        // 예약 전체조회 성공 여부
        boolean success = responseReservationsGetDTOList != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "예약 전체조회 성공" : "예약 전체조회 시 DAO 검색 실패");
        requestMap.put("reservationInfo", responseReservationsGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 예약 삭제
    @DeleteMapping("/cancel")
    public ResponseEntity<Map<String, Object>> deleteReservation(@RequestBody RequestReservationDeleteDTO requestReservationDeleteDTO) {

        // 예약 삭제 service
        ResponseReservationDeleteDTO responseReservationDeleteDTO = reservationService.deleteReservation(requestReservationDeleteDTO);

        // 예약 삭제 성공 여부
        boolean success = responseReservationDeleteDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "예약 삭제 성공" : "예약 삭제 시 DAO 저장 실패");
        requestMap.put("deleteInfo", responseReservationDeleteDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 예약 완료
    @DeleteMapping("/complete")
    public ResponseEntity<Map<String, Object>> completeReservation(@RequestBody RequestReservationCompleteDTO requestReservationCompleteDTO) {

        // 예약 삭제 service
        ResponseReservationCompleteDTO responseReservationCompleteDTO = reservationService.completeReservation(requestReservationCompleteDTO);

        // 예약 삭제 성공 여부
        boolean success = responseReservationCompleteDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "예약 완료 성공" : "예약 완료 시 DAO 저장 실패");
        requestMap.put("deleteInfo", responseReservationCompleteDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 예약 복구
    @PostMapping("/restore")
    public ResponseEntity<Map<String, Object>> restoreReservation(@RequestBody RequestReservationRestoreDTO requestReservationRestoreDTO) {

        // 예약 복구 service
        ResponseReservationRestoreDTO responseReservationRestoreDTO = reservationService.restoreReservation(requestReservationRestoreDTO);

        // 예약 복구 성공 여부
        boolean success = responseReservationRestoreDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "예약 복구 성공" : "예약 복구 시 DAO 저장 실패");
        requestMap.put("restoreInfo", responseReservationRestoreDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 예약 가능여부 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateReservation(@RequestBody RequestReservationUpdateDTO requestReservationUpdateDTO) {

        // 예약 가능여부 수정 service
        ResponseReservationUpdateDTO responseReservationUpdateDTO = reservationService.updateReservation(requestReservationUpdateDTO);

        // 예약 가능여부 수정 성공 여부
        boolean success = responseReservationUpdateDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "예약 가능여부 수정 성공" : "예약 가능여부 수정 시 DAO 저장 실패");
        requestMap.put("reservationInfo", responseReservationUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
