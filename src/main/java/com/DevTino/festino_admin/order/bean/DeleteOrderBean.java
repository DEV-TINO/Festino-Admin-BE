package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
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
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public DeleteOrderBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 주문 취소
    public Boolean exec(UUID boothId, RequestOrderDeleteDTO requestOrderDeleteDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return false;

        // orderId로 해당 Order DAO 찾고, orderType 값을 CANCEL로 변경
        OrderDTO orderDTO = getOrderDAOBean.exec(requestOrderDeleteDTO.getOrderId(), adminName);
        if (orderDTO == null) return false;

        //orderType 값을 CANCEL로 변경
        orderDTO.setOrderType(OrderType.CANCEL);

        // 변경된 DAO 저장
        saveOrderDAOBean.exec(adminName, orderDTO);
        return true;

    }

}
