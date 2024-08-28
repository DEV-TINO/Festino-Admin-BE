package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderFinishRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
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
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateOrderFinishRestoreBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, SaveCookDAOBean saveCookDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderFinishRestoreUpdateDTOBean createOrderFinishRestoreUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderFinishRestoreUpdateDTOBean = createOrderFinishRestoreUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // Order 조리 완료 복구
    public ResponseOrderFinishRestoreUpdateDTO exec(UUID boothId, RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(requestOrderFinishRestoreUpdateDTO.getOrderId(), adminName);
        if (orderDTO == null) return null;

        // DTO / DAO의 OrderType 비교, 다르다면 null 리턴
        if (!orderDTO.getOrderType().name().equals(requestOrderFinishRestoreUpdateDTO.getOrderType())) return null;

        // orderId에 해당하는 Cook DAO 모두 찾아서 isFinish를 false로 변경
        List<CookDTO> cookDTOList = getCooksDAOBean.exec(adminName, orderDTO.getOrderId());
        for (CookDTO cookDTO : cookDTOList){ cookDTO.setIsFinish(false); }

        // 변경된 cookDAOList 저장
        saveCookDAOBean.exec(cookDTOList, adminName);

        // DAO 수정
        orderDTO.setOrderType(OrderType.COOKING);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(adminName, orderDTO);

        // DTO 설정 및 반환
        return createOrderFinishRestoreUpdateDTOBean.exec(orderDTO);

    }

}
