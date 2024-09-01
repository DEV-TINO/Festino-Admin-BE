package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class UpdateOrderFinishBean {

    GetOrderDAOBean getOrderDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderFinishUpdateDTOBean createOrderFinishUpdateDTOBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateOrderFinishBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, SaveCookDAOBean saveCookDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderFinishUpdateDTOBean createOrderFinishUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderFinishUpdateDTOBean = createOrderFinishUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // Order 조리 완료
    public ResponseOrderFinishUpdateDTO exec(UUID boothId, RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(adminName, requestOrderFinishUpdateDTO.getOrderId());
        if (orderDTO == null) return null;

        // DTO / DAO의 OrderType 비교, 다르다면 null 리턴
        if (!orderDTO.getOrderType().name().equals(requestOrderFinishUpdateDTO.getOrderType())) return null;

        // orderId에 해당하는 Cook DAO 모두 찾아서 isFinish를 true로 변경
        List<CookDTO> cookDTOList = getCooksDAOBean.exec(adminName, orderDTO.getOrderId());
        for (CookDTO cookDTO : cookDTOList){ cookDTO.setIsFinish(true); }

        // 변경된 cookDAOList 저장
        saveCookDAOBean.exec(adminName, cookDTOList);

        // DAO 수정
        orderDTO.setOrderType(OrderType.FINISH);
        orderDTO.setFinishAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(adminName, orderDTO);

        // DTO 설정 및 반환
        return createOrderFinishUpdateDTOBean.exec(orderDTO);

    }


}
