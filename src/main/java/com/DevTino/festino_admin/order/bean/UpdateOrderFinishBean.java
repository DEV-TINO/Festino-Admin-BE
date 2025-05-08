package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UpdateOrderFinishBean {

    GetOrderDAOBean getOrderDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderFinishUpdateDTOBean createOrderFinishUpdateDTOBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public UpdateOrderFinishBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, SaveCookDAOBean saveCookDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderFinishUpdateDTOBean createOrderFinishUpdateDTOBean, BoothNameResolver boothNameResolver) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderFinishUpdateDTOBean = createOrderFinishUpdateDTOBean;
        this.boothNameResolver = boothNameResolver;
    }



    // Order 조리 완료
    public ResponseOrderFinishUpdateDTO exec(UUID boothId, RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        // orderId로 해당 Order 찾고
        OrderDTO orderDTO = getOrderDAOBean.exec(boothId, requestOrderFinishUpdateDTO.getOrderId());
        if (orderDTO == null) return null;

        // OrderType 비교, 다르다면 null 리턴
        if (!orderDTO.getOrderType().name().equals(requestOrderFinishUpdateDTO.getOrderType())) return null;

        // orderId에 해당하는 Cook DAO 모두 찾아서 isFinish를 true로 변경
        List<CookDTO> cookDTOList = getCooksDAOBean.exec(boothId, orderDTO.getOrderId());
        for (CookDTO cookDTO : cookDTOList){ cookDTO.setIsFinish(true); }

        // 변경된 cookDAOList 저장
        saveCookDAOBean.exec(boothId, cookDTOList);

        // DAO 수정
        orderDTO.setOrderType(OrderType.FINISH);
        orderDTO.setFinishAt(DateTimeUtils.nowZone());

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(boothId, orderDTO);

        // DTO 설정 및 반환
        return createOrderFinishUpdateDTOBean.exec(orderDTO);

    }


}
