package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDeleteRestoreUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDeleteRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderDeleteRestoreBean {

    GetOrderDAOBean getOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDeleteRestoreUpdateDTOBean createOrderDeleteRestoreUpdateDTOBean;

    @Autowired
    public UpdateOrderDeleteRestoreBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDeleteRestoreUpdateDTOBean createOrderDeleteRestoreUpdateDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDeleteRestoreUpdateDTOBean = createOrderDeleteRestoreUpdateDTOBean;
    }



    // 주문 취소 복구
    public ResponseOrderDeleteRestoreUpdateDTO exec(RequestOrderDeleteRestoreUpdateDTO requestOrderDeleteRestoreUpdateDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestOrderDeleteRestoreUpdateDTO.getOrderId());
        if (orderDAO == null) return null;

        // DTO / DAO의 OrderType 비교, 다르다면 null 리턴
        if (!orderDAO.getOrderType().name().equals(requestOrderDeleteRestoreUpdateDTO.getOrderType())) return null;

        // DAO 수정
        orderDAO.setOrderType(OrderType.COOKING);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(orderDAO);

        // DTO 설정 및 반환
        return createOrderDeleteRestoreUpdateDTOBean.exec(orderDAO);

    }

}
