package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDeleteRestoreUpdateDTOBean;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDeleteRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateOrderDeleteRestoreBean {

    GetOrderDAOBean getOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDeleteRestoreUpdateDTOBean createOrderDeleteRestoreUpdateDTOBean;
    BoothNameResolver boothNameResolver;

    @Autowired
    public UpdateOrderDeleteRestoreBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDeleteRestoreUpdateDTOBean createOrderDeleteRestoreUpdateDTOBean, BoothNameResolver boothNameResolver) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDeleteRestoreUpdateDTOBean = createOrderDeleteRestoreUpdateDTOBean;
        this.boothNameResolver = boothNameResolver;
    }



    // 주문 취소 복구
    public ResponseOrderDeleteRestoreUpdateDTO exec(UUID boothId, RequestOrderDeleteRestoreUpdateDTO requestOrderDeleteRestoreUpdateDTO){

        // orderId로 해당 Order 찾고
        OrderDTO orderDTO = getOrderDAOBean.exec(boothId, requestOrderDeleteRestoreUpdateDTO.getOrderId());
        if (orderDTO == null) return null;

        // OrderType 비교, 다르다면 null 리턴
        if (!orderDTO.getOrderType().name().equals(requestOrderDeleteRestoreUpdateDTO.getOrderType())) return null;

        // Order 수정
        orderDTO.setOrderType(OrderType.COOKING);

        // 수정된 Order 저장
        saveOrderDAOBean.exec(boothId, orderDTO);

        // DTO 설정 및 반환
        return createOrderDeleteRestoreUpdateDTOBean.exec(orderDTO);

    }

}
