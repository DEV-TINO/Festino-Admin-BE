package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderFinishUpdateDTOBean {

    // Order 조리 완료 DTO 생성해 반환
    public ResponseOrderFinishUpdateDTO exec(OrderDTO orderDTO){

        return ResponseOrderFinishUpdateDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderType(orderDTO.getOrderType().name())
                .build();

    }

}
