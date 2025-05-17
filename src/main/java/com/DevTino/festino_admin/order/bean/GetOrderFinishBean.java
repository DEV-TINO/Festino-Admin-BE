package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderFinishGetDTOsBean;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.bean.small.GetOrderFinishDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderFinishBean {

    GetOrderFinishDAOBean getOrderFinishDAOBean;
    CreateOrderFinishGetDTOsBean createOrderFinishGetDTOsBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderFinishBean(GetOrderFinishDAOBean getOrderFinishDAOBean, CreateOrderFinishGetDTOsBean createOrderFinishGetDTOsBean, BoothNameResolver boothNameResolver) {
        this.getOrderFinishDAOBean = getOrderFinishDAOBean;
        this.createOrderFinishGetDTOsBean = createOrderFinishGetDTOsBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> exec(UUID boothId, Integer date){

        // 날짜의 조리완료 상태인 Order 오래된순 전체 조회 -> DAO 리스트
        List<OrderDTO> dtoList = getOrderFinishDAOBean.exec(boothId, date);

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderFinishGetDTOsBean.exec(dtoList);

    }

}
