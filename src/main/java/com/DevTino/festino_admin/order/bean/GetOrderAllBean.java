package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderAllGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrdersDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderAllBean {

    GetOrdersDAOBean getOrdersDAOBean;
    CreateOrderAllGetDTOsBean createOrderAllGetDTOsBean;

    @Autowired
    public GetOrderAllBean(GetOrdersDAOBean getOrdersDAOBean, CreateOrderAllGetDTOsBean createOrderAllGetDTOsBean){
        this.getOrdersDAOBean = getOrdersDAOBean;
        this.createOrderAllGetDTOsBean = createOrderAllGetDTOsBean;
    }



    // 주문 전체 조회
    public List<ResponseOrderAllGetDTO> exec(UUID boothId, Integer date){

        // 해당 boothId, 날짜의 Order 최신순 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrdersDAOBean.exec(boothId, date);
        if (daoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderAllGetDTOsBean.exec(daoList);

    }

}
