package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDeleteRestoreUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
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
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateOrderDeleteRestoreBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDeleteRestoreUpdateDTOBean createOrderDeleteRestoreUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDeleteRestoreUpdateDTOBean = createOrderDeleteRestoreUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 주문 취소 복구
    public ResponseOrderDeleteRestoreUpdateDTO exec(UUID boothId, RequestOrderDeleteRestoreUpdateDTO requestOrderDeleteRestoreUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(requestOrderDeleteRestoreUpdateDTO.getOrderId(), adminName);
        if (orderDTO == null) return null;

        // DTO / DAO의 OrderType 비교, 다르다면 null 리턴
        if (!orderDTO.getOrderType().name().equals(requestOrderDeleteRestoreUpdateDTO.getOrderType())) return null;

        // DAO 수정
        orderDTO.setOrderType(OrderType.COOKING);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(adminName, orderDTO);

        // DTO 설정 및 반환
        return createOrderDeleteRestoreUpdateDTOBean.exec(orderDTO);

    }

}
