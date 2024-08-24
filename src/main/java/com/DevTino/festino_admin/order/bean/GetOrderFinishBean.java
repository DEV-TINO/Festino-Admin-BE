package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderFinishGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderFinishDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetOrderFinishBean {

    GetOrderFinishDAOBean getOrderFinishDAOBean;
    CreateOrderFinishGetDTOsBean createOrderFinishGetDTOsBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public GetOrderFinishBean(GetOrderFinishDAOBean getOrderFinishDAOBean, CreateOrderFinishGetDTOsBean createOrderFinishGetDTOsBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderFinishDAOBean = getOrderFinishDAOBean;
        this.createOrderFinishGetDTOsBean = createOrderFinishGetDTOsBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> exec(UUID boothId, Integer date){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return new ArrayList<>();

        // 날짜의 조리완료 상태인 Order 오래된순 전체 조회 -> DAO 리스트
        List<OrderDTO> dtoList = getOrderFinishDAOBean.exec(adminName, date);
        if (dtoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderFinishGetDTOsBean.exec(dtoList);

    }

}
