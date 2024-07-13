package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderFinishUpdateDTOBean {

    public ResponseOrderFinishUpdateDTO exec(OrderDAO orderDAO){

        return ResponseOrderFinishUpdateDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderType(orderDAO.getOrderType().name())
                .build();

    }

}
