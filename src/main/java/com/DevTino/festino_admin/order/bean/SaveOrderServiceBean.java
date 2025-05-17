package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderServiceSaveDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveOrderServiceBean {

    GetNightBoothDAOBean getNightBoothDAOBean;
    CheckOrderDAODateFieldBean checkOrderDAODateFieldBean;
    BoothNameResolver boothNameResolver;
    UpdateOrderServiceSaveDTOBean updateOrderServiceSaveDTOBean;
    CreateOrderDAOBean createOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateCookDAOsBean createCookDAOsBean;

    @Autowired
    public SaveOrderServiceBean(GetNightBoothDAOBean getNightBoothDAOBean, CheckOrderDAODateFieldBean checkOrderDAODateFieldBean, BoothNameResolver boothNameResolver, UpdateOrderServiceSaveDTOBean updateOrderServiceSaveDTOBean, CreateOrderDAOBean createOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, UpdateOrderDepositBean updateOrderDepositBean, CreateCookDAOsBean createCookDAOsBean){
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.checkOrderDAODateFieldBean = checkOrderDAODateFieldBean;
        this.boothNameResolver = boothNameResolver;
        this.updateOrderServiceSaveDTOBean = updateOrderServiceSaveDTOBean;
        this.createOrderDAOBean = createOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createCookDAOsBean = createCookDAOsBean;
    }



    // 서비스 주문 등록
    public UUID exec(UUID boothId, RequestOrderServiceSaveDTO requestOrderServiceSaveDTO){

        // 부스 정보 조회
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(boothId);

        // 부스가 닫혀 있거나 주문 불가할 경우 예외 발생
        if (!nightBoothDAO.getIsOpen()) throw new ServiceException(ExceptionEnum.BOOTH_CLOSED);
        if (!nightBoothDAO.getIsOrder()) throw new ServiceException(ExceptionEnum.ORDER_DISABLED);

        // 날짜 조회
        Integer date = checkOrderDAODateFieldBean.exec(nightBoothDAO);

        // 서비스 주문이라면 가격을 모두 0으로 수정
        if (requestOrderServiceSaveDTO.getIsService()){ updateOrderServiceSaveDTOBean.exec(requestOrderServiceSaveDTO); }

        // 주문 정보 생성
        OrderDTO orderDTO = createOrderDAOBean.exec(date, boothId, requestOrderServiceSaveDTO);

        // 주문 정보 저장
        saveOrderDAOBean.exec(boothId, orderDTO);

        // orderDTO의 메뉴 정보에 따라 CookDAO 생성
        createCookDAOsBean.exec(boothId, orderDTO);

        // 생성된 orderId 리턴
        return orderDTO.getOrderId();

    }

}
