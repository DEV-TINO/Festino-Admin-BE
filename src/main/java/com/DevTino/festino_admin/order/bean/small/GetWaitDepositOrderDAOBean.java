package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetWaitDepositOrderDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public GetWaitDepositOrderDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }



    // 입금대기 중인 Order 전체 조회
    public List<OrderDAO> exec(){

        return orderRepositoryJPA.findByIsDeposit(false);

    }

}
