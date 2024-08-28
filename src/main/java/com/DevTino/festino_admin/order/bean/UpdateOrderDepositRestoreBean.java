package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositRestoreUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UpdateOrderDepositRestoreBean {

    GetOrderDAOBean getOrderDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    DeleteCooksDAOBean deleteCooksDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDepositRestoreUpdateDTOBean createOrderDepositRestoreUpdateDTOBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateOrderDepositRestoreBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, DeleteCooksDAOBean deleteCooksDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDepositRestoreUpdateDTOBean createOrderDepositRestoreUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.deleteCooksDAOBean = deleteCooksDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDepositRestoreUpdateDTOBean = createOrderDepositRestoreUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 입금 확인 복구
    public ResponseOrderDepositRestoreUpdateDTO exec(UUID boothId, RequestOrderDepositRestoreUpdateDTO requestOrderDepositRestoreUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // orderId로 해당 Order DAO 찾기
        OrderDTO orderDTO = getOrderDAOBean.exec(adminName, requestOrderDepositRestoreUpdateDTO.getOrderId());

        // orderDAO를 찾을 수 없거나 이미 입금 전 상태인 주문이라면 null 리턴
        if ((orderDTO == null) || (orderDTO.getIsDeposit() == false)) return null;

        // orderId에 해당하는 Cook DAO 모두 검색
        List<CookDTO> cookDTOList = getCooksDAOBean.exec(adminName, orderDTO.getOrderId());

        // 검색한 Cook 리스트 삭제
        deleteCooksDAOBean.exec(adminName, cookDTOList);

        // DAO 수정
        orderDTO.setIsDeposit(false);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(adminName, orderDTO);

        // 반환할 DTO 생성 및 반환
        return createOrderDepositRestoreUpdateDTOBean.exec(orderDTO);

    }

}
