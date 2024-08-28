package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderTableGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
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
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public GetOrderTableBean(GetOrderCookingDAOBean getOrderCookingDAOBean, CreateOrderTableGetDTOsBean createOrderTableGetDTOsBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderCookingDAOBean = getOrderCookingDAOBean;
        this.createOrderTableGetDTOsBean = createOrderTableGetDTOsBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 테이블 주문 현황 조회
    public List<ResponseOrderTableGetDTO> exec(UUID boothId, Integer date){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // 날짜의 조리중인 Order 오래된순 전체 조회
        List<OrderDTO> orderDTOList = getOrderCookingDAOBean.exec(adminName, date);

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderTableGetDTOsBean.exec(adminName, orderDTOList);

    }

}
