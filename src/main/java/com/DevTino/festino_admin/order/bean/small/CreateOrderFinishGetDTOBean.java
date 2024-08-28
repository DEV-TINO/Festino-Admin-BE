package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderFinishGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderFinishGetDTO exec(OrderDTO orderDTO){

        return ResponseOrderFinishGetDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderNum(orderDTO.getOrderNum())
                .tableNum(orderDTO.getTableNum())
                .userName(orderDTO.getUserName())
                .phoneNum(orderDTO.getPhoneNum())
                .totalPrice(orderDTO.getTotalPrice())
                .menuList(orderDTO.getMenuInfo())
                .build();

    }

}
