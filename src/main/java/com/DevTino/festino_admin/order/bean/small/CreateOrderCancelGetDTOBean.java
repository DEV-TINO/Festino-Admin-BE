package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCancelGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderCancelGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderCancelGetDTO exec(OrderDAO orderDAO){

        return ResponseOrderCancelGetDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderNum(orderDAO.getOrderNum())
                .tableNum(orderDAO.getTableNum())
                .userName(orderDAO.getUserName())
                .phoneNum(orderDAO.getPhoneNum())
                .totalPrice(orderDAO.getTotalPrice())
                .menuInfo(orderDAO.getMenuInfo())
                .build();

    }
}
