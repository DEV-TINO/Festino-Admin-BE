package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateOrderDepositBean {

    GetOrderDAOBean getOrderDAOBean;
    CreateCookDAOsBean createCookDAOsBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public UpdateOrderDepositBean(GetOrderDAOBean getOrderDAOBean, CreateCookDAOsBean createCookDAOsBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean, BoothNameResolver boothNameResolver) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.createCookDAOsBean = createCookDAOsBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDepositUpdateDTOBean = createOrderDepositUpdateDTOBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO exec(UUID boothId, RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        // orderId로 해당 Order 찾고
        OrderDTO orderDTO = getOrderDAOBean.exec(boothId, requestOrderDepositUpdateDTO.getOrderId());

        // orderDAO를 찾을 수 없거나 이미 입금 완료된 주문이라면 null 리턴
        if ((orderDTO == null) || (orderDTO.getIsDeposit())) return null;

        // orderDAO의 메뉴 정보에 따라 CookDAO 생성
        createCookDAOsBean.exec(boothId, orderDTO);

        // DAO 수정
        orderDTO.setIsDeposit(true);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(boothId, orderDTO);

        // 반환할 DTO 생성 및 반환
        return createOrderDepositUpdateDTOBean.exec(orderDTO);

    }

}
