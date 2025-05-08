package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderTableGetDTOsBean;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.bean.small.GetOrderCookingDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderTableBean {

    GetOrderCookingDAOBean getOrderCookingDAOBean;
    CreateOrderTableGetDTOsBean createOrderTableGetDTOsBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderTableBean(GetOrderCookingDAOBean getOrderCookingDAOBean, CreateOrderTableGetDTOsBean createOrderTableGetDTOsBean, BoothNameResolver boothNameResolver) {
        this.getOrderCookingDAOBean = getOrderCookingDAOBean;
        this.createOrderTableGetDTOsBean = createOrderTableGetDTOsBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 테이블 주문 현황 조회
    public List<ResponseOrderTableGetDTO> exec(UUID boothId, Integer date){

        // 날짜의 조리중인 Order 오래된순 전체 조회
        List<OrderDTO> orderDTOList = getOrderCookingDAOBean.exec(boothId, date);

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderTableGetDTOsBean.exec(boothId, orderDTOList);

    }

}
