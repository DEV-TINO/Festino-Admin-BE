package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.OrderRepository;
import com.DevTino.festino_admin.order.repository.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class SaveOrderDAOBean {

    private final Map<String, OrderRepository> orderRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public SaveOrderDAOBean(Map<String, OrderRepository> orderRepositoryMap, BoothNameResolver boothNameResolver){
        this.orderRepositoryMap = orderRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // 주문 DAO를 DB에 저장
    public void exec(UUID boothId, OrderDTO orderDTO) {

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.exec(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        OrderRepository orderRepository = orderRepositoryMap.get(boothName);
        
        // 저장
        orderRepository.save(orderDTO);

    }

}
