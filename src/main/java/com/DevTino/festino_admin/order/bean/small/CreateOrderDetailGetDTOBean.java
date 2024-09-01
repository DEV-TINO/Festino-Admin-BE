package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDetailGetDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderDetailGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderDetailGetDTO exec(OrderDTO orderDTO){

        return ResponseOrderDetailGetDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderNum(orderDTO.getOrderNum())
                .tableNum(orderDTO.getTableNum())
                .userName(orderDTO.getUserName())
                .phoneNum(orderDTO.getPhoneNum())
                .note(orderDTO.getNote())
                .totalPrice(orderDTO.getTotalPrice())
                .menuList(orderDTO.getMenuInfo())
                .build();

    }
}
