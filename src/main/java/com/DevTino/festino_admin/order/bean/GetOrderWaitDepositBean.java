package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderWaitDepositGetDTOsBean;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.bean.small.GetOrderWaitDepositDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderWaitDepositBean {

    GetOrderWaitDepositDAOBean getOrderWaitDepositDAOBean;
    CreateOrderWaitDepositGetDTOsBean createOrderWaitDepositGetDTOsBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderWaitDepositBean(GetOrderWaitDepositDAOBean getOrderWaitDepositDAOBean, CreateOrderWaitDepositGetDTOsBean createOrderWaitDepositGetDTOsBean, BoothNameResolver boothNameResolver) {
        this.getOrderWaitDepositDAOBean = getOrderWaitDepositDAOBean;
        this.createOrderWaitDepositGetDTOsBean = createOrderWaitDepositGetDTOsBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 입금대기 주문 조회
    public List<ResponseOrderWaitDepositGetDTO> exec(UUID boothId, Integer date){

        // 날짜의 입금 대기 중인 Order 오래된순 전체 조회 -> DAO 리스트
        List<OrderDTO> dtoList = getOrderWaitDepositDAOBean.exec(boothId, date);

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderWaitDepositGetDTOsBean.exec(dtoList);

    }

}
