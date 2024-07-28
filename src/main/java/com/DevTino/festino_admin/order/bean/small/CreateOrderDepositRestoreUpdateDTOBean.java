package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDepositRestoreUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseOrderDepositRestoreUpdateDTO exec(OrderDAO orderDAO){

        return ResponseOrderDepositRestoreUpdateDTO.builder()
                .orderId(orderDAO.getOrderId())
                .isDeposit(orderDAO.getIsDeposit())
                .build();

    }

}
