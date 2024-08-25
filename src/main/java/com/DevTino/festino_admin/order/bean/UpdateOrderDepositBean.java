package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateOrderDepositBean {

    GetOrderDAOBean getOrderDAOBean;
    CreateCookDAOsBean createCookDAOsBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateOrderDepositBean(GetOrderDAOBean getOrderDAOBean, CreateCookDAOsBean createCookDAOsBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.createCookDAOsBean = createCookDAOsBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDepositUpdateDTOBean = createOrderDepositUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 입금 확인
    public ResponseOrderDepositUpdateDTO exec(UUID boothId, RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(requestOrderDepositUpdateDTO.getOrderId(), adminName);
        // orderDAO를 찾을 수 없거나 이미 입금 완료된 주문이라면 null 리턴
        if ((orderDTO == null) || (orderDTO.getIsDeposit())) return null;

        // orderDAO의 메뉴 정보에 따라 CookDAO 생성
        createCookDAOsBean.exec(orderDTO, adminName);

        // DAO 수정
        orderDTO.setIsDeposit(true);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(adminName, orderDTO);

        // 반환할 DTO 생성 및 반환
        return createOrderDepositUpdateDTOBean.exec(orderDTO);

    }

}
