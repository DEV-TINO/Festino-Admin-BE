package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderCookingDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public GetOrderCookingDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }

    // 해당 날짜의 조리중인 Order 최신순 전체 조회
    public List<OrderDAO> exec(Integer date){

        return orderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtDesc(true, OrderType.COOKING, date);

    }
}
