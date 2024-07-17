package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.*;
import com.DevTino.festino_admin.order.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    GetDetailOrderBean getDetailOrderBean;
    GetWaitDepositOrdersBean getWaitDepositOrdersBean;
    GetFinishOrdersBean getFinishOrdersBean;
    GetCancelOrdersBean getCancelOrdersBean;
    DeleteOrderBean deleteOrderBean;
    UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean;
    UpdateOrderDepositBean updateOrderDepositBean;
    UpdateOrderFinishBean updateOrderFinishBean;
    UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean;

    @Autowired
    public OrderService(GetDetailOrderBean getDetailOrderBean, GetWaitDepositOrdersBean getWaitDepositOrdersBean, GetFinishOrdersBean getFinishOrdersBean, GetCancelOrdersBean getCancelOrdersBean, DeleteOrderBean deleteOrderBean, UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean, UpdateOrderDepositBean updateOrderDepositBean, UpdateOrderFinishBean updateOrderFinishBean, UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean){
        this.getDetailOrderBean = getDetailOrderBean;
        this.getWaitDepositOrdersBean = getWaitDepositOrdersBean;
        this.getFinishOrdersBean = getFinishOrdersBean;
        this.getCancelOrdersBean = getCancelOrdersBean;
        this.deleteOrderBean = deleteOrderBean;
        this.updateOrderDeleteRestoreBean = updateOrderDeleteRestoreBean;
        this.updateOrderDepositBean = updateOrderDepositBean;
        this.updateOrderFinishBean = updateOrderFinishBean;
        this.updateOrderFinishRestoreBean = updateOrderFinishRestoreBean;
    }



    // 주문 상세 조회
    public ResponseOrderDetailGetDTO getDetailOrder(RequestOrderDetailGetDTO requestOrderDetailGetDTO){

        return getDetailOrderBean.exec(requestOrderDetailGetDTO);

    }



    // 입금대기 주문 조회
    public List<ResponseOrderWaitDepositGetDTO> getWaitDepositOrderAll(){

        return getWaitDepositOrdersBean.exec();

    }



    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> getFinishOrderAll(){

        return getFinishOrdersBean.exec();

    }



    // 취소 주문 조회
    public List<ResponseOrderCancelGetDTO> getCancelOrderAll(){

        return getCancelOrdersBean.exec();

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



    // Order 조리 완료
    public ResponseOrderFinishUpdateDTO updateOrderFinish(RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        return updateOrderFinishBean.exec(requestOrderFinishUpdateDTO);

    }



    // Order 조리 완료 복구
    public ResponseOrderFinishRestoreUpdateDTO updateOrderFinishRestore(RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){

        return updateOrderFinishRestoreBean.exec(requestOrderFinishRestoreUpdateDTO);

    }

}
