package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderDepositBean {

    GetOrderDAOBean getOrderDAOBean;
    CreateCookDAOsBean createCookDAOsBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean;

    @Autowired
    public UpdateOrderDepositBean(GetOrderDAOBean getOrderDAOBean, CreateCookDAOsBean createCookDAOsBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.createCookDAOsBean = createCookDAOsBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDepositUpdateDTOBean = createOrderDepositUpdateDTOBean;
    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO exec(RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestOrderDepositUpdateDTO.getOrderId());

        // orderDAO를 찾을 수 없거나 이미 입금 완료된 주문이라면 null 리턴
        if ((orderDAO == null) || (orderDAO.getIsDeposit())) return null;

        // orderDAO의 메뉴 정보에 따라 CookDAO 생성
        createCookDAOsBean.exec(orderDAO);

        // DAO 수정
        orderDAO.setIsDeposit(true);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(orderDAO);

        // 반환할 DTO 생성 및 반환
        return createOrderDepositUpdateDTOBean.exec(orderDAO);

    }

}
