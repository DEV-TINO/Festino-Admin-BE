package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class DeleteOrderBean {

    GetOrderDAOBean getOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public DeleteOrderBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, BoothNameResolver boothNameResolver) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 주문 취소
    public Boolean exec(UUID boothId, RequestOrderDeleteDTO requestOrderDeleteDTO){

        // orderId로 해당 Order 찾고
        OrderDTO orderDTO = getOrderDAOBean.exec(boothId, requestOrderDeleteDTO.getOrderId());
        if (orderDTO == null) return false;

        //orderType 값을 CANCEL로 변경
        orderDTO.setOrderType(OrderType.CANCEL);

        // 변경된 Order 저장
        saveOrderDAOBean.exec(boothId, orderDTO);
        return true;

    }

}
