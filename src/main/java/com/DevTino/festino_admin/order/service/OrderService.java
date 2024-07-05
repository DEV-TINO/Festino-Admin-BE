package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.DeleteOrderBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    DeleteOrderBean deleteOrderBean;

    @Autowired
    public OrderService(DeleteOrderBean deleteOrderBean){
        this.deleteOrderBean = deleteOrderBean;
    }



    // 주문 취소
    public Boolean deleteOrder(RequestOrderDeleteDTO requestOrderDeleteDTO){

        return deleteOrderBean.exec(requestOrderDeleteDTO);

    }
}
