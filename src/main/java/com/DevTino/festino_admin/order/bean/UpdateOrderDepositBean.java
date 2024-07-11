package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class UpdateOrderDepositBean {

    GetOrderDAOBean getOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateCookDAOBean createCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean;

    @Autowired
    public UpdateOrderDepositBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateCookDAOBean createCookDAOBean, SaveCookDAOBean saveCookDAOBean,CreateOrderDepositUpdateDTOBean createOrderDepositUpdateDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createCookDAOBean = createCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.createOrderDepositUpdateDTOBean = createOrderDepositUpdateDTOBean;
    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO exec(RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        // orderId로 해당 Order DAO 찾기
        UUID orderId = requestOrderDepositUpdateDTO.getOrderId();
        OrderDAO orderDAO = getOrderDAOBean.exec(orderId);
        if (orderDAO == null) return null;

        // DAO 수정
        orderDAO.setIsDeposit(true);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(orderDAO);

        // 메뉴 정보 받기
        List<Map<String, Object>> menuList = orderDAO.getMenuInfo();

        // menuList에서 하나씩 꺼내서
        for (Map<String, Object> menu : menuList){

            // 메뉴 정보로 Cook DAO 생성
            CookDAO cookDAO = createCookDAOBean.exec(menu, orderId);

            // 생성한 Cook DAO 저장
            saveCookDAOBean.exec(cookDAO);

        }

        // 반환할 DTO 생성 및 반환
        return createOrderDepositUpdateDTOBean.exec(orderDAO);

    }

}
