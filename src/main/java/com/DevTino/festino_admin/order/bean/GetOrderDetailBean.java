package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDetailGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDetailGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDetailGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetOrderDetailBean {

    GetOrderDAOBean getOrderDAOBean;
    CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean;

    @Autowired
    public GetOrderDetailBean(GetOrderDAOBean getOrderDAOBean, CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.createOrderDetailGetDTOBean = createOrderDetailGetDTOBean;
    }



    // 주문 상세 조회
    public ResponseOrderDetailGetDTO exec(RequestOrderDetailGetDTO requestOrderDetailGetDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestOrderDetailGetDTO.getOrderId());
        if (orderDAO == null) return null;

        // DTO 생성해 반환
        return createOrderDetailGetDTOBean.exec(orderDAO);

    }

}
