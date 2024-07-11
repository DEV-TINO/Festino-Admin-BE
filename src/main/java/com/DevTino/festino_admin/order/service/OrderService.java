package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.DeleteOrderBean;
import com.DevTino.festino_admin.order.bean.UpdateOrderDepositBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDeleteDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    DeleteOrderBean deleteOrderBean;
    UpdateOrderDepositBean updateOrderDepositBean;

    @Autowired
    public OrderService(DeleteOrderBean deleteOrderBean, UpdateOrderDepositBean updateOrderDepositBean){
        this.deleteOrderBean = deleteOrderBean;
        this.updateOrderDepositBean = updateOrderDepositBean;
    }



    // 주문 취소
    public Boolean deleteOrder(RequestOrderDeleteDTO requestOrderDeleteDTO){

        return deleteOrderBean.exec(requestOrderDeleteDTO);

    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO updateOrderDeposit(RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        return updateOrderDepositBean.exec(requestOrderDepositUpdateDTO);

    }
}
