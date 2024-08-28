package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDepositRestoreUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseOrderDepositRestoreUpdateDTO exec(OrderDTO orderDTO){

        return ResponseOrderDepositRestoreUpdateDTO.builder()
                .orderId(orderDTO.getOrderId())
                .isDeposit(orderDTO.getIsDeposit())
                .build();

    }

}
