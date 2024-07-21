package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.order.domain.DTO.*;
import com.DevTino.festino_admin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/booth/{boothId}/order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    // 테이블 주문 현황 조회
    @GetMapping("/table")
    public ResponseEntity<Map<String, Object>> getOrderTable(){

        // 테이블 주문 현황 조회 service 실행
        List<ResponseOrderTableGetDTO> dtoList = orderService.getOrderTable();

        // 테이블 주문 현황 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "테이블 주문 현황 조회 성공" : "테이블 주문 현황 조회 시 DAO 검색 실패");
        requestMap.put("orderList", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 주문 상세 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderDetail(@PathVariable UUID orderId){

        // 주문 상세 조회 service 실행
        ResponseOrderDetailGetDTO responseOrderDetailGetDTO = orderService.getOrderDetail(orderId);

        // 주문 상세 조회 성공 여부 설정
        boolean success = (responseOrderDetailGetDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주문 상세 조회 성공" : "주문 상세 조회 시 DAO 검색 실패");
        requestMap.put("orderInfo", responseOrderDetailGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 전체 주문 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getOrderAll(){

        // 전체 주문 조회 service 실행
        List<ResponseOrderAllGetDTO> dtoList = orderService.getOrderAll();

        // 전체 주문 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "전체 주문 조회 성공" : "전체 주문 조회 시 DAO 검색 실패");
        requestMap.put("orderList", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 실시간 주문 조회
    @GetMapping("/now/all")
    public ResponseEntity<Map<String, Object>> getOrderNowAll(@PathVariable UUID boothId){

        // 실시간 주문 조회 service 실행
        ResponseOrderNowGetDTO responseOrderNowGetDTO = orderService.getOrderNowAll(boothId);

        // 실시간 주문 조회 성공 여부 설정
        boolean success = (responseOrderNowGetDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "실시간 주문 조회 성공" : "실시간 주문 조회 시 DAO 검색 실패");
        requestMap.put("nowInfo", responseOrderNowGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 입금대기 주문 조회
    @GetMapping("/deposit/all")
    public ResponseEntity<Map<String, Object>> getOrderWaitDepositAll(){

        // 입금대기 주문 조회 service 실행
        List<ResponseOrderWaitDepositGetDTO> dtoList = orderService.getOrderWaitDepositAll();

        // 입금대기 주문 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "입금대기 주문 조회 성공" : "입금대기 주문 조회 시 DAO 검색 실패");
        requestMap.put("waitDepositList", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 조리중 주문 조회
    @GetMapping("/cooking/all")
    public ResponseEntity<Map<String, Object>> getOrderCookingAll(@PathVariable UUID boothId){

        // 조리중 주문 조회 service 실행
        List<ResponseOrderCookingGetDTO> dtoList = orderService.getOrderCookingAll(boothId);

        // 조리중 주문 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "조리중 주문 조회 성공" : "조리중 주문 조회 시 DAO 검색 실패");
        requestMap.put("cookingList", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 조리완료 주문 조회
    @GetMapping("/finish/all")
    public ResponseEntity<Map<String, Object>> getOrderFinishAll(){

        // 조리완료 주문 조회 service 실행
        List<ResponseOrderFinishGetDTO> dtoList = orderService.getOrderFinishAll();

        // 조리완료 주문 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "조리완료 주문 조회 성공" : "조리완료 주문 조회 시 DAO 검색 실패");
        requestMap.put("finishList", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 취소 주문 조회
    @GetMapping("/cancel/all")
    public ResponseEntity<Map<String, Object>> getOrderCancelAll(){

        // 취소 주문 조회 service 실행
        List<ResponseOrderCancelGetDTO> dtoList = orderService.getOrderCancelAll();

        // 취소 주문 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "취소 주문 조회 성공" : "취소 주문 조회 시 DAO 검색 실패");
        requestMap.put("cancelList", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 주문 통계 조회
    @GetMapping("/statistic/{date}")
    public ResponseEntity<Map<String, Object>> getOrderStatistic(@PathVariable UUID boothId, @PathVariable Integer date){

        // 통계 조회 service 실행
        ResponseOrderStatisticGetDTO responseOrderStatisticGetDTO = orderService.getOrderStatistic(boothId, date);

        // 통계 조회 성공 여부 설정
        boolean success = (responseOrderStatisticGetDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "통계 조회 성공" : "통계 조회 시 DAO 검색 실패");
        requestMap.put("statistic", responseOrderStatisticGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 주문 취소
    @DeleteMapping("/cancel")
    public ResponseEntity<Map<String, Object>> deleteOrder(@RequestBody RequestOrderDeleteDTO requestOrderDeleteDTO){

        // 주문 취소 service 실행 & 삭제 성공 여부 설정
        boolean success = orderService.deleteOrder(requestOrderDeleteDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주문 취소 성공" : "주문 취소 시 DAO 검색 실패");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 주문 취소 복구
    @PutMapping("/cancel/restore")
    public ResponseEntity<Map<String, Object>> updateOrderDeleteRestore(@RequestBody RequestOrderDeleteRestoreUpdateDTO requestOrderDeleteRestoreUpdateDTO){

        // 주문 취소 복구 service 실행
        ResponseOrderDeleteRestoreUpdateDTO responseOrderDeleteRestoreUpdateDTO = orderService.updateOrderDeleteRestore(requestOrderDeleteRestoreUpdateDTO);

        // 주문 취소 복구 성공 여부 설정
        boolean success = (responseOrderDeleteRestoreUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주문 취소 복구 성공" : "주문 취소 시 DAO 검색 실패 또는 OrderType 불일치");
        requestMap.put("restoreInfo", responseOrderDeleteRestoreUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 입금 확인
    @PutMapping("/deposit")
    public ResponseEntity<Map<String, Object>> updateIsDeposit(@RequestBody RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        // 입금 확인 service 실행
        ResponseOrderDepositUpdateDTO responseOrderDepositUpdateDTO = orderService.updateOrderDeposit(requestOrderDepositUpdateDTO);

        // 입금 확인 성공 여부 설정
        boolean success = (responseOrderDepositUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "입금 확인 성공" : "입금 확인 시 DAO 검색 실패");
        requestMap.put("depositInfo", responseOrderDepositUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // Order 조리 완료
    @PutMapping("/finish")
    public ResponseEntity<Map<String, Object>> updateOrderFinish(@RequestBody RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        // Order 조리 완료 service 실행
        ResponseOrderFinishUpdateDTO responseOrderFinishUpdateDTO = orderService.updateOrderFinish(requestOrderFinishUpdateDTO);

        // Order 조리 완료 성공 여부 설정
        boolean success = (responseOrderFinishUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "Order 조리 완료 성공" : "Order 조리 완료 시 DAO 검색 실패 또는 OrderType 불일치");
        requestMap.put("finishInfo", responseOrderFinishUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // Order 조리 완료 복구
    @PutMapping("/finish/restore")
    public ResponseEntity<Map<String, Object>> updateOrderFinishRestore(@RequestBody RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){

        // Order 조리 완료 복구 service 실행
        ResponseOrderFinishRestoreUpdateDTO responseOrderFinishRestoreUpdateDTO = orderService.updateOrderFinishRestore(requestOrderFinishRestoreUpdateDTO);

        // Order 조리 완료 복구 성공 여부 설정
        boolean success = (responseOrderFinishRestoreUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "Order 조리 완료 복구 성공" : "Order 조리 완료 복구 시 DAO 검색 실패 또는 OrderType 불일치");
        requestMap.put("restoreInfo", responseOrderFinishRestoreUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}