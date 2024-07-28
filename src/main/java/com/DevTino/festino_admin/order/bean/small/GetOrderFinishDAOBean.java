package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderFinishDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public GetOrderFinishDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }



    // 해당 boothId, 날짜의 조리완료 상태인 Order 오래된순 전체 조회
    public List<OrderDAO> exec(UUID boothId, Integer date){

        return orderRepositoryJPA.findByBoothIdAndOrderTypeAndDateOrderByCreateAtAsc(boothId, OrderType.FINISH, date);

    }

}
