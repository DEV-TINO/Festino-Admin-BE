package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderDetailGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestDetailOrderGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseDetailOrderGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDetailOrderBean {

    GetOrderDAOBean getOrderDAOBean;
    CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean;

    @Autowired
    public GetDetailOrderBean(GetOrderDAOBean getOrderDAOBean, CreateOrderDetailGetDTOBean createOrderDetailGetDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.createOrderDetailGetDTOBean = createOrderDetailGetDTOBean;
    }



    // 주문 상세 조회
    public ResponseDetailOrderGetDTO exec(RequestDetailOrderGetDTO requestDetailOrderGetDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestDetailOrderGetDTO.getOrderId());
        if (orderDAO == null) return null;

        // DTO 생성해 반환
        return createOrderDetailGetDTOBean.exec(orderDAO);

    }

}
