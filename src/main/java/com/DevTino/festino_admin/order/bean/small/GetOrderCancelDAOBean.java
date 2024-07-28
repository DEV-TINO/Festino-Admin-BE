package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderCancelDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public GetOrderCancelDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }



    // 해당 boothid, 날짜의 취소 상태인 Order 최신순 전체 조회
    public List<OrderDAO> exec(UUID boothId, Integer date){

        return orderRepositoryJPA.findByBoothIdAndOrderTypeAndDateOrderByCreateAtDesc(boothId, OrderType.CANCEL, date);

    }

}
