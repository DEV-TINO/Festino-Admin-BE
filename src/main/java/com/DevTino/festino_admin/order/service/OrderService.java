package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.*;
import com.DevTino.festino_admin.order.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class OrderService {

    GetOrderTableBean getOrderTableBean;
    GetOrderDetailBean getOrderDetailBean;
    GetOrderAllBean getOrderAllBean;
    GetOrderNowBean getOrderNowBean;
    GetOrderWaitDepositBean getOrderWaitDepositBean;
    GetOrderCookingBean getOrderCookingBean;
    GetOrderFinishBean getOrderFinishBean;
    GetOrderCancelBean getOrderCancelBean;
    GetOrderStatisticBean getOrderStatisticBean;
    DeleteOrderBean deleteOrderBean;
    UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean;
    UpdateOrderDepositBean updateOrderDepositBean;
    UpdateOrderDepositRestoreBean updateOrderDepositRestoreBean;
    UpdateOrderFinishBean updateOrderFinishBean;
    UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean;

    @Autowired
    public OrderService(GetOrderTableBean getOrderTableBean, GetOrderDetailBean getOrderDetailBean, GetOrderAllBean getOrderAllBean, GetOrderNowBean getOrderNowBean, GetOrderWaitDepositBean getOrderWaitDepositBean, GetOrderCookingBean getOrderCookingBean, GetOrderFinishBean getOrderFinishBean, GetOrderCancelBean getOrderCancelBean, GetOrderStatisticBean getOrderStatisticBean, DeleteOrderBean deleteOrderBean, UpdateOrderDeleteRestoreBean updateOrderDeleteRestoreBean, UpdateOrderDepositBean updateOrderDepositBean, UpdateOrderDepositRestoreBean updateOrderDepositRestoreBean, UpdateOrderFinishBean updateOrderFinishBean, UpdateOrderFinishRestoreBean updateOrderFinishRestoreBean){
        this.getOrderTableBean = getOrderTableBean;
        this.getOrderDetailBean = getOrderDetailBean;
        this.getOrderAllBean = getOrderAllBean;
        this.getOrderNowBean = getOrderNowBean;
        this.getOrderWaitDepositBean = getOrderWaitDepositBean;
        this.getOrderCookingBean = getOrderCookingBean;
        this.getOrderFinishBean = getOrderFinishBean;
        this.getOrderCancelBean = getOrderCancelBean;
        this.getOrderStatisticBean = getOrderStatisticBean;
        this.deleteOrderBean = deleteOrderBean;
        this.updateOrderDeleteRestoreBean = updateOrderDeleteRestoreBean;
        this.updateOrderDepositBean = updateOrderDepositBean;
        this.updateOrderDepositRestoreBean = updateOrderDepositRestoreBean;
        this.updateOrderFinishBean = updateOrderFinishBean;
        this.updateOrderFinishRestoreBean = updateOrderFinishRestoreBean;
    }



    // 테이블 주문 현황 조회
    public List<ResponseOrderTableGetDTO> getOrderTable(UUID boothId, Integer date){

        return getOrderTableBean.exec(boothId, date);

    }



    // 주문 상세 조회
    public ResponseOrderDetailGetDTO getOrderDetail(UUID boothId, UUID orderId){

        return getOrderDetailBean.exec(boothId, orderId);

    }



    // 전체 주문 조회
    public List<ResponseOrderAllGetDTO> getOrderAll(UUID boothId, Integer date){

        return getOrderAllBean.exec(boothId, date);

    }



    // 실시간 주문 조회
    public ResponseOrderNowGetDTO getOrderNowAll(UUID boothId, Integer date){

        return getOrderNowBean.exec(boothId, date);

    }



    // 입금대기 주문 조회
    public List<ResponseOrderWaitDepositGetDTO> getOrderWaitDepositAll(UUID boothId, Integer date){

        return getOrderWaitDepositBean.exec(boothId, date);

    }



    // 조리중 주문 조회
    public List<ResponseOrderCookingGetDTO> getOrderCookingAll(UUID boothId, Integer date){

        return getOrderCookingBean.exec(boothId, date);

    }



    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> getOrderFinishAll(UUID boothId, Integer date){

        return getOrderFinishBean.exec(boothId, date);

    }



    // 취소 주문 조회
    public List<ResponseOrderCancelGetDTO> getOrderCancelAll(UUID boothId, Integer date){

        return getOrderCancelBean.exec(boothId, date);

    }



    // 주문 통계 조회
    public ResponseOrderStatisticGetDTO getOrderStatistic(UUID boothId, Integer date){

        return getOrderStatisticBean.exec(boothId, date);

    }



    // 주문 취소
    public Boolean deleteOrder(UUID boothId, RequestOrderDeleteDTO requestOrderDeleteDTO){

        return deleteOrderBean.exec(boothId, requestOrderDeleteDTO);

    }



    // 주문 취소 복구
    public ResponseOrderDeleteRestoreUpdateDTO updateOrderDeleteRestore(UUID boothId, RequestOrderDeleteRestoreUpdateDTO requestOrderDeleteRestoreUpdateDTO){

        return updateOrderDeleteRestoreBean.exec(boothId, requestOrderDeleteRestoreUpdateDTO);

    }



    // 입금 확인
    public ResponseOrderDepositUpdateDTO updateOrderDeposit(UUID boothId, RequestOrderDepositUpdateDTO requestOrderDepositUpdateDTO){

        return updateOrderDepositBean.exec(boothId, requestOrderDepositUpdateDTO);

    }



    // 입금 확인 복구
    public ResponseOrderDepositRestoreUpdateDTO updateOrderDepositRestore(RequestOrderDepositRestoreUpdateDTO requestOrderDepositRestoreUpdateDTO){

        return updateOrderDepositRestoreBean.exec(requestOrderDepositRestoreUpdateDTO);

    }



    // Order 조리 완료
    public ResponseOrderFinishUpdateDTO updateOrderFinish(UUID boothId, RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        return updateOrderFinishBean.exec(boothId, requestOrderFinishUpdateDTO);

    }



    // Order 조리 완료 복구
    public ResponseOrderFinishRestoreUpdateDTO updateOrderFinishRestore(RequestOrderFinishRestoreUpdateDTO requestOrderFinishRestoreUpdateDTO){

        return updateOrderFinishRestoreBean.exec(requestOrderFinishRestoreUpdateDTO);

    }

}
