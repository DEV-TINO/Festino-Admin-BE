package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.repository.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    @Autowired
    public SaveOrderDAOBean(OrderRepositoryJPA orderRepositoryJPA){
        this.orderRepositoryJPA = orderRepositoryJPA;
    }



    // 주문 DAO를 DB에 저장
    public void exec(OrderDAO orderDAO){

        orderRepositoryJPA.save(orderDAO);

    }

}
