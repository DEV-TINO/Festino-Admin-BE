package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderWaitDepositGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderWaitDepositGetDTO exec(OrderDTO orderDTO){

        return ResponseOrderWaitDepositGetDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderNum(orderDTO.getOrderNum())
                .tableNum(orderDTO.getTableNum())
                .userName(orderDTO.getUserName())
                .phoneNum(orderDTO.getPhoneNum())
                .totalPrice(orderDTO.getTotalPrice())
                .menuList(orderDTO.getMenuInfo())
                .createAt(orderDTO.getCreateAt())
                .build();

    }

}
