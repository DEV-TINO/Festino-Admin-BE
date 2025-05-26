package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GetOrderCookingDAOBean {

    private final Map<String, OrderRepository<?>> orderRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderCookingDAOBean(Map<String, OrderRepository<?>> orderRepositoryMap, BoothNameResolver boothNameResolver){
        this.orderRepositoryMap = orderRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // 날짜의 조리중인 Order 오래된순 전체 조회
    public List<OrderDTO> exec(UUID boothId, Integer date){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.exec(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        OrderRepository<?> orderRepository = orderRepositoryMap.get(boothName);
        System.out.println("orderRepository = " + orderRepository);
        System.out.println("date = " + date);
        System.out.println("b = " + boothId);
        System.out.println("orderRepository = " + orderRepository.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(true, OrderType.COOKING, date));
        System.out.println("orderRepository = " + orderRepository);
        // OrderDAO 리스트 조회
        List<? extends AbstractOrderDAO> orderDAOList = orderRepository.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(true, OrderType.COOKING, date);
        if (orderDAOList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);
        System.out.println("orderDAOList = " + orderDAOList);
        
        // OrderDAO 리스트를 OrderDTO 리스트로 변환해 반환
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (AbstractOrderDAO dao : orderDAOList) { orderDTOList.add(OrderDTO.fromAbstractOrderDAO(dao)); }
        return orderDTOList;

    }

}
