package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.DeleteOrderBean;
import com.DevTino.festino_admin.order.bean.UpdateCookEndBean;
import com.DevTino.festino_admin.order.bean.UpdateOrderDepositBean;
import com.DevTino.festino_admin.order.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    DeleteOrderBean deleteOrderBean;
    UpdateOrderDepositBean updateOrderDepositBean;
    UpdateCookEndBean updateCookEndBean;

    @Autowired
    public OrderService(DeleteOrderBean deleteOrderBean, UpdateOrderDepositBean updateOrderDepositBean, UpdateCookEndBean updateCookEndBean){
        this.deleteOrderBean = deleteOrderBean;
        this.updateOrderDepositBean = updateOrderDepositBean;
        this.updateCookEndBean = updateCookEndBean;
    }



    // 주문 취소
    public Boolean deleteOrder(RequestOrderDeleteDTO requestOrderDeleteDTO){

        return deleteOrderBean.exec(requestOrderDeleteDTO);

    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO updateOrderDeposit(RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        return updateOrderDepositBean.exec(requestOrderDepositUpdateDTO);

    }



    // Cook 조리 완료
    public ResponseCookEndUpdateDTO updateCookIsEnd(RequestCookEndUpdateDTO requestCookEndUpdateDTO){

        return updateCookEndBean.exec(requestCookEndUpdateDTO);

    }

}
