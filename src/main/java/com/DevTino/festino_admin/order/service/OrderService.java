package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.*;
import com.DevTino.festino_admin.order.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    GetWaitDepositOrdersBean getWaitDepositOrdersBean;
    DeleteOrderBean deleteOrderBean;
    UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean;
    UpdateOrderDepositBean updateOrderDepositBean;
    UpdateCookFinishBean updateCookFinishBean;
    UpdateOrderFinishBean updateOrderFinishBean;
    UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean;
    UpdateCookCountBean updateCookCountBean;

    @Autowired
    public OrderService(GetWaitDepositOrdersBean getWaitDepositOrdersBean, DeleteOrderBean deleteOrderBean, UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean, UpdateOrderDepositBean updateOrderDepositBean, UpdateCookFinishBean updateCookFinishBean, UpdateOrderFinishBean updateOrderFinishBean, UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean, UpdateCookCountBean updateCookCountBean){
        this.getWaitDepositOrdersBean = getWaitDepositOrdersBean;
        this.deleteOrderBean = deleteOrderBean;
        this.updateOrderDeleteRestoreBean = updateOrderDeleteRestoreBean;
        this.updateOrderDepositBean = updateOrderDepositBean;
        this.updateCookFinishBean = updateCookFinishBean;
        this.updateOrderFinishBean = updateOrderFinishBean;
        this.updateOrderFinishRestoreBean = updateOrderFinishRestoreBean;
        this.updateCookCountBean = updateCookCountBean;
    }



    // 입금대기 주문 조회
    public List<ResponseWaitDepositOrderGetDTO> getWaitDepositOrderAll(){

        return getWaitDepositOrdersBean.exec();

    }



    // 주문 취소
    public Boolean deleteOrder(RequestOrderDeleteDTO requestOrderDeleteDTO){

        return deleteOrderBean.exec(requestOrderDeleteDTO);

    }



    // 주문 취소 복구
    public ResponseOrderDeleteRestoreDTO updateOrderDeleteRestore(RequestOrderDeleteRestoreDTO requestOrderDeleteRestoreDTO){

        return updateOrderDeleteRestoreBean.exec(requestOrderDeleteRestoreDTO);

    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO updateOrderDeposit(RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        return updateOrderDepositBean.exec(requestOrderDepositUpdateDTO);

    }



    // Cook 조리 완료
    public ResponseCookFinishUpdateDTO updateCookFinish(RequestCookFinishUpdateDTO requestCookFinishUpdateDTO){

        return updateCookFinishBean.exec(requestCookFinishUpdateDTO);

    }



    // Order 조리 완료
    public ResponseOrderFinishUpdateDTO updateOrderFinish(RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        return updateOrderFinishBean.exec(requestOrderFinishUpdateDTO);

    }



    // Order 조리 완료 복구
    public ResponseOrderFinishRestoreUpdateDTO updateOrderFinishRestore(RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){

        return updateOrderFinishRestoreBean.exec(requestOrderFinishRestoreUpdateDTO);

    }



    // 서빙 수량 변경
    public ResponseCookCountUpdateDTO updateCookCount(RequestCookCountUpdateDTO requestCookCountUpdateDTO){

        return updateCookCountBean.exec(requestCookCountUpdateDTO);

    }

}
