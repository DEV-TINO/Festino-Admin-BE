package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDetailGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDetailGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetOrderDetailBean {

    GetOrderDAOBean getOrderDAOBean;
    CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public GetOrderDetailBean(GetOrderDAOBean getOrderDAOBean, CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.createOrderDetailGetDTOBean = createOrderDetailGetDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 주문 상세 조회
    public ResponseOrderDetailGetDTO exec(UUID boothId, UUID orderId){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(adminName, orderId);
        if (orderDTO == null) return null;

        // DTO 생성해 반환
        return createOrderDetailGetDTOBean.exec(orderDTO);

    }

}
