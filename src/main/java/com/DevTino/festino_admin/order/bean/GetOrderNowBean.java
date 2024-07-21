package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderNowGetDTOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCookingGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderNowGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderNowBean {

    GetOrderWaitDepositBean getOrderWaitDepositBean;
    GetOrderCookingBean getOrderCookingBean;
    GetOrderFinishBean getOrderFinishBean;
    CreateOrderNowGetDTOBean createOrderNowGetDTOBean;

    @Autowired
    public GetOrderNowBean(GetOrderWaitDepositBean getOrderWaitDepositBean, GetOrderCookingBean getOrderCookingBean, GetOrderFinishBean getOrderFinishBean, CreateOrderNowGetDTOBean createOrderNowGetDTOBean){
        this.getOrderWaitDepositBean = getOrderWaitDepositBean;
        this.getOrderCookingBean = getOrderCookingBean;
        this.getOrderFinishBean = getOrderFinishBean;
        this.createOrderNowGetDTOBean = createOrderNowGetDTOBean;
    }



    // 실시간 주문 조회
    public ResponseOrderNowGetDTO exec(UUID boothId, Integer date){

        // 입금대기 리스트 조회
        List<ResponseOrderWaitDepositGetDTO> waitDepositList = getOrderWaitDepositBean.exec(date);
        if (waitDepositList == null) return null;

        // 조리중 리스트 조회
        List<ResponseOrderCookingGetDTO> cookingList = getOrderCookingBean.exec(boothId, date);
        if (cookingList == null) return null;

        // 조리완료 리스트 조회
        List<ResponseOrderFinishGetDTO> finishList = getOrderFinishBean.exec(date);
        if (finishList == null) return null;

        // DTO 생성해 반환
        return createOrderNowGetDTOBean.exec(waitDepositList, cookingList, finishList);

    }

}
