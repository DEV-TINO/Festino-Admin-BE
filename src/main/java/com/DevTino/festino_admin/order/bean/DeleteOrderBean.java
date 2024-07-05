package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.GetOrderDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveOrderDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeleteOrderBean {

    GetOrderDAOBean getOrderDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;

    @Autowired
    public DeleteOrderBean(GetOrderDAOBean getOrderDAOBean, SaveOrderDAOBean saveOrderDAOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
    }



    // 주문 삭제
    public Boolean exec(RequestOrderDeleteDTO requestOrderDeleteDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestOrderDeleteDTO.getOrderId());
        if (orderDAO == null) return false;

        // isDeleted 값을 true로 변경
        orderDAO.setIsDeleted(true);

        // 변경된 DAO 저장
        saveOrderDAOBean.exec(orderDAO);
        return true;

    }

}
