package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteDTO;
import com.DevTino.festino_admin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    // 주문 삭제
    @DeleteMapping("")
    public ResponseEntity<Map<String, Object>> deleteOrder(@RequestBody RequestOrderDeleteDTO requestOrderDeleteDTO){

        // 주문 삭제 service 실행 & 삭제 성공 여부 설정
        boolean success = orderService.deleteOrder(requestOrderDeleteDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "주문 삭제 성공" : "주문 삭제 시 DAO 검색 실패");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
