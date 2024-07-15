package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDeleteRestoreDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDeleteRestoreUpdateDTOBean {

    // 주문 취소 복구 DTO 생성해 반환
    public ResponseOrderDeleteRestoreDTO exec(OrderDAO orderDAO){

        return ResponseOrderDeleteRestoreDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderType(orderDAO.getOrderType().name())
                .build();

    }

}
