package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderFinishUpdateDTOBean {

    // Order 조리 완료 DTO 생성해 반환
    public ResponseOrderFinishUpdateDTO exec(OrderDAO orderDAO){

        return ResponseOrderFinishUpdateDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderType(orderDAO.getOrderType().name())
                .build();

    }

}
