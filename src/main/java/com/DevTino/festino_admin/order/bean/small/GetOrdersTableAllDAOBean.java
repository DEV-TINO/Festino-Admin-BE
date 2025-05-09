package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GetOrdersTableAllDAOBean {

    private final Map<String, OrderRepository<?>> orderRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrdersTableAllDAOBean(Map<String, OrderRepository<?>> orderRepositoryMap, BoothNameResolver boothNameResolver){
        this.orderRepositoryMap = orderRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }

    // 날짜의 전체 주문 오래된순 조회
    public List<OrderDTO> exec(UUID boothId, Integer tableNum){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.exec(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        OrderRepository<?> orderRepository = orderRepositoryMap.get(boothName);

        // OrderDAO 리스트 조회
        List<? extends AbstractOrderDAO> orderDAOList = orderRepository.findByTableNumOrderByCreateAtAsc(tableNum);
        if (orderDAOList.isEmpty()) return new ArrayList<>();

        // OrderDAO 리스트를 OrderDTO 리스트로 변환해 반환
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (AbstractOrderDAO dao : orderDAOList) {
            orderDTOS.add(OrderDTO.fromAbstractOrderDAO(dao));
        }
        return orderDTOS;

    }
}
