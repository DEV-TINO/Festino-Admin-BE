package com.DevTino.festino_admin.reservation.controller;

import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import com.DevTino.festino_admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/reservation")
public class ReservationController {
    ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 예약 전체조회
    @GetMapping("/all/booth/{boothId}")
    public ResponseEntity<Map<String, Object>> getReservationAll(@PathVariable("boothId") UUID boothId) {

        // 예약 전체조회 service
        ResponseReservationsGetDTO responseReservationsGetDTOList = reservationService.getReservationAll(boothId);

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
    @PutMapping("/delete")
    public ResponseEntity<Map<String, Object>> updateReservationDelete(@RequestBody RequestReservationDeleteUpdateDTO requestReservationDeleteUpdateDTO) {

        // 예약 삭제 service
        ResponseReservationDeleteUpdateDTO responseReservationDeleteUpdateDTO = reservationService.updateReservationDelete(requestReservationDeleteUpdateDTO);

        // 예약 삭제 성공 여부
        boolean success = responseReservationDeleteUpdateDTO != null;

        // Map을 통해 메시지와 id값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "예약 삭제 성공" : "예약 삭제 시 DAO 저장 실패");
        requestMap.put("deleteInfo", responseReservationDeleteUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
