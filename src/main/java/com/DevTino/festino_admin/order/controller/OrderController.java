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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/booth/{boothId}/order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    // 입금대기 주문 조회
    @GetMapping("/wait-deposit")
    public ResponseEntity<Map<String, Object>> getWaitDepositOrderAll(){

        // 입금대기 주문 조회 service 실행
        List<ResponseWaitDepositOrderGetDTO> dtoList = orderService.getWaitDepositOrderAll();

        // 입금대기 주문 조회 성공 여부 설정
        boolean success = (dtoList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "입금대기 주문 조회 성공" : "입금대기 주문 조회 시 DAO 검색 실패");
        requestMap.put("orders", dtoList);

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
    public ResponseEntity<Map<String, Object>> updateOrderDeleteRestore(@RequestBody RequestOrderDeleteRestoreDTO requestOrderDeleteRestoreDTO){

        // 주문 취소 복구 service 실행
        ResponseOrderDeleteRestoreDTO responseOrderDeleteRestoreDTO = orderService.updateOrderDeleteRestore(requestOrderDeleteRestoreDTO);

        // 주문 취소 복구 성공 여부 설정
        boolean success = (responseOrderDeleteRestoreDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주문 취소 복구 성공" : "주문 취소 시 DAO 검색 실패 또는 OrderType 불일치");
        requestMap.put("restoreInfo", responseOrderDeleteRestoreDTO);

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



    // Cook 조리 완료
    @PutMapping("/cook/finish")
    public ResponseEntity<Map<String, Object>> updateCookIsEnd(@RequestBody RequestCookEndUpdateDTO requestCookEndUpdateDTO){

        // Cook 조리 완료 service 실행
        ResponseCookEndUpdateDTO responseCookEndUpdateDTO = orderService.updateCookIsEnd(requestCookEndUpdateDTO);

        // Cook 조리 완료 성공 여부 설정
        boolean success = (responseCookEndUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "Cook 조리 완료 성공" : "Cook 조리 완료 시 DAO 검색 실패");
        requestMap.put("endInfo", responseCookEndUpdateDTO);

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



    // 서빙 수량 변경
    @PutMapping("/cook/count")
    public ResponseEntity<Map<String, Object>> updateCookCount(@RequestBody RequestCookCountUpdateDTO requestCookCountUpdateDTO){

        // 서빙 수량 변경 service 실행
        ResponseCookCountUpdateDTO responseCookCountUpdateDTO = orderService.updateCookCount(requestCookCountUpdateDTO);

        // 서빙 수량 변경 성공 여부 설정
        boolean success = (responseCookCountUpdateDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "서빙 수량 변경 성공" : "서빙 수량 변경 시 DAO 검색 실패 또는 부적절한 servedCount 값");
        requestMap.put("restoreInfo", responseCookCountUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
