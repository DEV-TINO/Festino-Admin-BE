package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderFinishRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UpdateOrderFinishRestoreBean {

    GetOrderDAOBean getOrderDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderFinishRestoreUpdateDTOBean createOrderFinishRestoreUpdateDTOBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public UpdateOrderFinishRestoreBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, SaveCookDAOBean saveCookDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderFinishRestoreUpdateDTOBean createOrderFinishRestoreUpdateDTOBean, BoothNameResolver boothNameResolver) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderFinishRestoreUpdateDTOBean = createOrderFinishRestoreUpdateDTOBean;
        this.boothNameResolver = boothNameResolver;
    }



    // Order 조리 완료 복구
    public ResponseOrderFinishRestoreUpdateDTO exec(UUID boothId, RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){

        // orderId로 해당 Order 찾고
        OrderDTO orderDTO = getOrderDAOBean.exec(boothId, requestOrderFinishRestoreUpdateDTO.getOrderId());

        // OrderType 비교, 다르다면 예외 발생
        if (!orderDTO.getOrderType().name().equals(requestOrderFinishRestoreUpdateDTO.getOrderType())) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // orderId에 해당하는 Cook DAO 모두 찾아서 isFinish를 false로 변경
        List<CookDTO> cookDTOList = getCooksDAOBean.exec(boothId, orderDTO.getOrderId());
        for (CookDTO cookDTO : cookDTOList){ cookDTO.setIsFinish(false); }

        // 변경된 cookDAOList 저장
        saveCookDAOBean.exec(boothId, cookDTOList);

        // DAO 수정
        orderDTO.setOrderType(OrderType.COOKING);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(boothId, orderDTO);

        // DTO 설정 및 반환
        return createOrderFinishRestoreUpdateDTOBean.exec(orderDTO);

    }

}
