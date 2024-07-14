package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderFinishRestoreUpdateDTOBean {

    // Order 조리 완료 복구 DTO 생성해 반환
    public ResponseOrderFinishRestoreUpdateDTO exec(OrderDAO orderDAO){

        return ResponseOrderFinishRestoreUpdateDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderType(orderDAO.getOrderType().name())
                .build();

    }

}
