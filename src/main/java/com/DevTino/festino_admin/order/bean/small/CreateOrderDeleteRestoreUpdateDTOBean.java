package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDeleteRestoreUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDeleteRestoreUpdateDTOBean {

    // 주문 취소 복구 DTO 생성해 반환
    public ResponseOrderDeleteRestoreUpdateDTO exec(OrderDTO orderDTO){

        return ResponseOrderDeleteRestoreUpdateDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderType(orderDTO.getOrderType().name())
                .build();

    }

}
