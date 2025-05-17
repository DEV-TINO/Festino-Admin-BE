package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDetailGetDTOBean;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
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
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderDetailBean(GetOrderDAOBean getOrderDAOBean, CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean, BoothNameResolver boothNameResolver) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.createOrderDetailGetDTOBean = createOrderDetailGetDTOBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 주문 상세 조회
    public ResponseOrderDetailGetDTO exec(UUID boothId, UUID orderId){

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(boothId, orderId);

        // DTO 생성해 반환
        return createOrderDetailGetDTOBean.exec(orderDTO);

    }

}
