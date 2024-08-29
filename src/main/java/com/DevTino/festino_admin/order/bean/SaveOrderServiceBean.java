package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderServiceSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveOrderServiceBean {

    GetNightBoothDAOBean getNightBoothDAOBean;
    CheckOrderDAODateFieldBean checkOrderDAODateFieldBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;
    CreateOrderDAOBean createOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateCookDAOsBean createCookDAOsBean;

    @Autowired
    public SaveOrderServiceBean(GetNightBoothDAOBean getNightBoothDAOBean, CheckOrderDAODateFieldBean checkOrderDAODateFieldBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean, CreateOrderDAOBean createOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, UpdateOrderDepositBean updateOrderDepositBean, CreateCookDAOsBean createCookDAOsBean){
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.checkOrderDAODateFieldBean = checkOrderDAODateFieldBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
        this.createOrderDAOBean = createOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createCookDAOsBean = createCookDAOsBean;
    }


    // 서비스 주문 등록
    public UUID exec(UUID boothId, RequestOrderServiceSaveDTO requestOrderServiceSaveDTO){

        // 부스 정보 조회
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(boothId);
        if (nightBoothDAO == null) return null;

        // 부스가 닫혀 있거나 주문 불가할 경우 주문 등록 실패
        if (!nightBoothDAO.getIsOpen() || !nightBoothDAO.getIsOrder()) return null;

        // 날짜 조회
        Integer date = checkOrderDAODateFieldBean.exec(nightBoothDAO);

        // 주문한 학과
        String adminName = getOrderBoothNameDAOBean.exec(boothId);

        // 주문한 학과가 없다면 주문 등록 실패
        if(adminName.isEmpty()) return null;

        // 주문 정보 생성
        OrderDTO orderDTO = createOrderDAOBean.exec(date, boothId, requestOrderServiceSaveDTO);

        // 주문 정보 저장
        saveOrderDAOBean.exec(adminName, orderDTO);

        // orderDTO의 메뉴 정보에 따라 CookDAO 생성
        createCookDAOsBean.exec(adminName, orderDTO);

        // 생성된 orderId 리턴
        return orderDTO.getOrderId();

    }

}
