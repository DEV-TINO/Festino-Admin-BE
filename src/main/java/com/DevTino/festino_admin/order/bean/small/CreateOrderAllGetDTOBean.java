package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderAllGetDTOBean {

    static String waitDeposit = "WAIT_DEPOSIT";

    // DTO 생성해 반환
    public ResponseOrderAllGetDTO exec(OrderDAO orderDAO){

        // orderType 설정
        String orderType;
        if (orderDAO.getIsDeposit() == false) orderType = waitDeposit;
        else orderType = orderDAO.getOrderType().name();

        // DTO 생성해 반환
        return ResponseOrderAllGetDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderType(orderType)
                .orderNum(orderDAO.getOrderNum())
                .tableNum(orderDAO.getTableNum())
                .userName(orderDAO.getUserName())
                .phoneNum(orderDAO.getPhoneNum())
                .totalPrice(orderDAO.getTotalPrice())
                .menuInfo(orderDAO.getMenuInfo())
                .build();

    }
}
