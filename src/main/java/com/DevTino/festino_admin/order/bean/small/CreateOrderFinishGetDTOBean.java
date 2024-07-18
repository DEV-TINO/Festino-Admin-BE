package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderFinishGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderFinishGetDTO exec(OrderDAO orderDAO){

        return ResponseOrderFinishGetDTO.builder()
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
