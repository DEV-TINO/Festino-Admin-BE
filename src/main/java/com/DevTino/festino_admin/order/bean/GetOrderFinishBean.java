package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderFinishGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderFinishDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderFinishBean {

    GetOrderFinishDAOBean getOrderFinishDAOBean;
    CreateOrderFinishGetDTOsBean createOrderFinishGetDTOsBean;

    @Autowired
    public GetOrderFinishBean(GetOrderFinishDAOBean getOrderFinishDAOBean, CreateOrderFinishGetDTOsBean createOrderFinishGetDTOsBean){
        this.getOrderFinishDAOBean = getOrderFinishDAOBean;
        this.createOrderFinishGetDTOsBean = createOrderFinishGetDTOsBean;
    }



    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> exec(UUID boothId, Integer date){

        // 해당 boothId, 날짜의 조리완료 상태인 Order 최신순 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrderFinishDAOBean.exec(boothId, date);
        if (daoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderFinishGetDTOsBean.exec(daoList);

    }

}
