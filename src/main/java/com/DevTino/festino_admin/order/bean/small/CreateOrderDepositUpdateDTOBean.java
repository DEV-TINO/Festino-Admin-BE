package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDepositUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseOrderDepositUpdateDTO exec(OrderDTO orderDTO){

        return ResponseOrderDepositUpdateDTO.builder()
                .orderId(orderDTO.getOrderId())
                .isDeposit(orderDTO.getIsDeposit())
                .build();

    }

}
