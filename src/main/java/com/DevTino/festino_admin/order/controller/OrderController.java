package com.DevTino.festino_admin.order.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.order.domain.DTO.*;
import com.DevTino.festino_admin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/table/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderTable(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 테이블 주문 현황 조회 service 실행
        List<ResponseOrderTableGetDTO> dtoList = orderService.getOrderTable(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "테이블 주문 현황 조회 성공", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 주문 상세 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<Object>> getOrderDetail(@PathVariable("boothId") UUID boothId, @PathVariable("orderId") UUID orderId){

        // 주문 상세 조회 service 실행
        ResponseOrderDetailGetDTO responseOrderDetailGetDTO = orderService.getOrderDetail(boothId, orderId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주문 상세 조회 성공", responseOrderDetailGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 전체 주문 조회
    @GetMapping("/all/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderAll(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 전체 주문 조회 service 실행
        List<ResponseOrderAllGetDTO> dtoList = orderService.getOrderAll(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "전체 주문 조회 성공", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 실시간 주문 조회
    @GetMapping("/now/all/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderNowAll(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 실시간 주문 조회 service 실행
        ResponseOrderNowGetDTO responseOrderNowGetDTO = orderService.getOrderNowAll(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "실시간 주문 조회 성공", responseOrderNowGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 입금대기 주문 조회
    @GetMapping("/deposit/all/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderWaitDepositAll(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 입금대기 주문 조회 service 실행
        List<ResponseOrderWaitDepositGetDTO> dtoList = orderService.getOrderWaitDepositAll(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "입금대기 주문 조회 성공", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 조리중 주문 조회
    @GetMapping("/cooking/all/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderCookingAll(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 조리중 주문 조회 service 실행
        List<ResponseOrderCookingGetDTO> dtoList = orderService.getOrderCookingAll(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "조리중 주문 조회 성공", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 조리완료 주문 조회
    @GetMapping("/finish/all/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderFinishAll(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 조리완료 주문 조회 service 실행
        List<ResponseOrderFinishGetDTO> dtoList = orderService.getOrderFinishAll(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "조리완료 주문 조회 성공", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 취소 주문 조회
    @GetMapping("/cancel/all/{date}")
    public ResponseEntity<ApiResponse<Object>> getOrderCancelAll(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date){

        // 취소 주문 조회 service 실행
        List<ResponseOrderCancelGetDTO> dtoList = orderService.getOrderCancelAll(boothId, date);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "취소 주문 조회 성공", dtoList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 주문 통계 조회
    @GetMapping("/statistic/{date}/{type}")
    public ResponseEntity<ApiResponse<Object>> getOrderStatistic(@PathVariable("boothId") UUID boothId, @PathVariable("date") Integer date, @PathVariable("type") String type){

        // 통계 조회 service 실행
        ResponseOrderStatisticGetDTO responseOrderStatisticGetDTO = orderService.getOrderStatistic(boothId, date, type);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "통계 조회 성공", responseOrderStatisticGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    // 테이블 별 주문 전체 조회
    @GetMapping("/all/table/{tableNum}")
    public ResponseEntity<ApiResponse<Object>> getOrderTableAll(@PathVariable("boothId") UUID boothId, @PathVariable("tableNum") Integer tableNum){

        // 테이블 별 주문 전체 조회 service 실행
        List<ResponseOrderTableAllGetDTO> responseOrderTableAllGetDTOS = orderService.getOrderTableAll(boothId, tableNum);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "테이블 별 주문 전체 조회 성공", responseOrderTableAllGetDTOS);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    // 주문 취소
    @DeleteMapping("/cancel")
    public ResponseEntity<ApiResponse<Object>> deleteOrder(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderDeleteDTO requestOrderDeleteDTO){

        // 주문 취소 service 실행
        orderService.deleteOrder(boothId, requestOrderDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주문 취소 성공", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 주문 취소 복구
    @PutMapping("/cancel/restore")
    public ResponseEntity<ApiResponse<Object>> updateOrderDeleteRestore(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderDeleteRestoreUpdateDTO requestOrderDeleteRestoreUpdateDTO){

        // 주문 취소 복구 service 실행
        ResponseOrderDeleteRestoreUpdateDTO responseOrderDeleteRestoreUpdateDTO = orderService.updateOrderDeleteRestore(boothId, requestOrderDeleteRestoreUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "주문 취소 복구 성공", responseOrderDeleteRestoreUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 입금 확인
    @PutMapping("/deposit")
    public ResponseEntity<ApiResponse<Object>> updateIsDeposit(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        // 입금 확인 service 실행
        ResponseOrderDepositUpdateDTO responseOrderDepositUpdateDTO = orderService.updateOrderDeposit(boothId, requestOrderDepositUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "입금 확인 성공", responseOrderDepositUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 입금 확인 복구
    @PutMapping("/deposit/restore")
    public ResponseEntity<ApiResponse<Object>> updateIsDepositRestore(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderDepositRestoreUpdateDTO requestOrderDepositRestoreUpdateDTO){

        // 입금 확인 복구 service 실행
        ResponseOrderDepositRestoreUpdateDTO responseOrderDepositRestoreUpdateDTO = orderService.updateOrderDepositRestore(boothId, requestOrderDepositRestoreUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "입금 확인 복구 성공", responseOrderDepositRestoreUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // Order 조리 완료
    @PutMapping("/finish")
    public ResponseEntity<ApiResponse<Object>> updateOrderFinish(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        // Order 조리 완료 service 실행
        ResponseOrderFinishUpdateDTO responseOrderFinishUpdateDTO = orderService.updateOrderFinish(boothId, requestOrderFinishUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "Order 조리 완료 성공", responseOrderFinishUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // Order 조리 완료 복구
    @PutMapping("/finish/restore")
    public ResponseEntity<ApiResponse<Object>> updateOrderFinishRestore(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){

        // Order 조리 완료 복구 service 실행
        ResponseOrderFinishRestoreUpdateDTO responseOrderFinishRestoreUpdateDTO = orderService.updateOrderFinishRestore(boothId, requestOrderFinishRestoreUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "Order 조리 완료 복구 성공", responseOrderFinishRestoreUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 서비스 주문 등록
    @PostMapping("/service")
    public ResponseEntity<ApiResponse<Object>> saveOrderService(@PathVariable("boothId") UUID boothId, @RequestBody RequestOrderServiceSaveDTO requestOrderServiceSaveDTO){

        // 서비스 주문 등록 service 실행
        UUID orderId = orderService.saveOrderService(boothId, requestOrderServiceSaveDTO);

        // message, success, id 값 json 데이터로 반환
        ApiResponse<Object> response = new ApiResponse<>(true, "서비스 주문 등록 성공", orderId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
