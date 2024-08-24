package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderAllGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrdersDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetOrderAllBean {

    GetOrdersDAOBean getOrdersDAOBean;
    CreateOrderAllGetDTOsBean createOrderAllGetDTOsBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public GetOrderAllBean(GetOrdersDAOBean getOrdersDAOBean, CreateOrderAllGetDTOsBean createOrderAllGetDTOsBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrdersDAOBean = getOrdersDAOBean;
        this.createOrderAllGetDTOsBean = createOrderAllGetDTOsBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 주문 전체 조회
    public List<ResponseOrderAllGetDTO> exec(UUID boothId, Integer date){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return new ArrayList<>();

        // 날짜의 Order 오래된순 전체 조회 -> DAO 리스트
        List<OrderDTO> dtoList = getOrdersDAOBean.exec(adminName, date);
        if (dtoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderAllGetDTOsBean.exec(dtoList);

    }

}
