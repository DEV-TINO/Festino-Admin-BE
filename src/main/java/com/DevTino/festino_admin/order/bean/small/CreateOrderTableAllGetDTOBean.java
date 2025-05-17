package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableAllGetDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderTableAllGetDTOBean {

    static String waitDeposit = "WAIT_DEPOSIT";

    // DTO 생성해 반환
    public ResponseOrderTableAllGetDTO exec(OrderDTO orderDTO){

        // orderType 설정
        String orderType;
        if (orderDTO.getIsDeposit() == false) orderType = waitDeposit;
        else orderType = orderDTO.getOrderType().name();

        // DTO 생성해 반환
        return ResponseOrderTableAllGetDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderType(orderType)
                .orderNum(orderDTO.getOrderNum())
                .tableNum(orderDTO.getTableNum())
                .userName(orderDTO.getUserName())
                .phoneNum(orderDTO.getPhoneNum())
                .totalPrice(orderDTO.getTotalPrice())
                .menuList(orderDTO.getMenuInfo())
                .createAt(orderDTO.getCreateAt())
                .finishAt(orderDTO.getFinishAt())
                .build();
    }
}