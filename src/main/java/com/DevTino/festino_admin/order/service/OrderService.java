package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.*;
import com.DevTino.festino_admin.order.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    GetOrderTableBean getOrderTableBean;
    GetOrderDetailBean getOrderDetailBean;
    GetOrderAllBean getOrderAllBean;
    GetOrderWaitDepositBean getOrderWaitDepositBean;
    GetOrderFinishBean getOrderFinishBean;
    GetOrderCancelBean getOrderCancelBean;
    DeleteOrderBean deleteOrderBean;
    UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean;
    UpdateOrderDepositBean updateOrderDepositBean;
    UpdateOrderFinishBean updateOrderFinishBean;
    UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean;

    @Autowired
    public OrderService(GetOrderTableBean getOrderTableBean, GetOrderDetailBean getOrderDetailBean, GetOrderAllBean getOrderAllBean, GetOrderWaitDepositBean getOrderWaitDepositBean, GetOrderFinishBean getOrderFinishBean, GetOrderCancelBean getOrderCancelBean, DeleteOrderBean deleteOrderBean, UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean, UpdateOrderDepositBean updateOrderDepositBean, UpdateOrderFinishBean updateOrderFinishBean, UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean){
        this.getOrderTableBean = getOrderTableBean;
        this.getOrderDetailBean = getOrderDetailBean;
        this.getOrderAllBean = getOrderAllBean;
        this.getOrderWaitDepositBean = getOrderWaitDepositBean;
        this.getOrderFinishBean = getOrderFinishBean;
        this.getOrderCancelBean = getOrderCancelBean;
        this.deleteOrderBean = deleteOrderBean;
        this.updateOrderDeleteRestoreBean = updateOrderDeleteRestoreBean;
        this.updateOrderDepositBean = updateOrderDepositBean;
        this.updateOrderFinishBean = updateOrderFinishBean;
        this.updateOrderFinishRestoreBean = updateOrderFinishRestoreBean;
    }



    // 테이블 주문 현황 조회
    public List<ResponseOrderTableGetDTO> getOrderTable(){

        return getOrderTableBean.exec();

    }



    // 주문 상세 조회
    public ResponseOrderDetailGetDTO getOrderDetail(RequestOrderDetailGetDTO requestOrderDetailGetDTO){

        return getOrderDetailBean.exec(requestOrderDetailGetDTO);

    }



    // 전체 주문 조회
    public List<ResponseOrderAllGetDTO> getOrderAll(){

        return getOrderAllBean.exec();

    }



    // 입금대기 주문 조회
    public List<ResponseOrderWaitDepositGetDTO> getOrderWaitDepositAll(){

        return getOrderWaitDepositBean.exec();

    }



    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> getOrderFinishAll(){

        return getOrderFinishBean.exec();

    }



    // 취소 주문 조회
    public List<ResponseOrderCancelGetDTO> getOrderCancelAll(){

        return getOrderCancelBean.exec();

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
