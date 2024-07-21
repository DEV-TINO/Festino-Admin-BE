package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrdersDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public GetOrdersDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }



    // 해당 날짜의 전체 주문 최신순 조회
    public List<OrderDAO> exec(Integer date){

        return orderRepositoryJPA.findByDateOrderByCreateAtDesc(date);

    }

}
