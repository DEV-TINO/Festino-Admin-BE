package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderCancelGetDTOsBean;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.bean.small.GetOrderCancelDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCancelGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderCancelBean {

    GetOrderCancelDAOBean getOrderCancelDAOBean;
    CreateOrderCancelGetDTOsBean createOrderCancelGetDTOsBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderCancelBean(GetOrderCancelDAOBean getOrderCancelDAOBean, CreateOrderCancelGetDTOsBean createOrderCancelGetDTOsBean, BoothNameResolver boothNameResolver) {
        this.getOrderCancelDAOBean = getOrderCancelDAOBean;
        this.createOrderCancelGetDTOsBean = createOrderCancelGetDTOsBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 취소 주문 조회
    public List<ResponseOrderCancelGetDTO> exec(UUID boothId, Integer date){

        // 날짜의 취소된 Order 오래된순 전체 조회 -> DAO 리스트
        List<OrderDTO> dtoList = getOrderCancelDAOBean.exec(boothId, date);
        if (dtoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderCancelGetDTOsBean.exec(dtoList);

    }

}
