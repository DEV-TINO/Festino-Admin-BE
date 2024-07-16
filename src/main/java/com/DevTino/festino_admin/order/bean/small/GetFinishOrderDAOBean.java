package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetFinishOrderDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public GetFinishOrderDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }



    // 조리완료 상태인 Order 전체 검색
    public List<OrderDAO> exec(){

        return orderRepositoryJPA.findByOrderType(OrderType.FINISH);

    }

}
