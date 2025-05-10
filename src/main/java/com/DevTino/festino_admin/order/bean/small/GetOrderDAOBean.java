package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class GetOrderDAOBean {

    private final Map<String, OrderRepository<?>> orderRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetOrderDAOBean(Map<String, OrderRepository<?>> orderRepositoryMap, BoothNameResolver boothNameResolver){
        this.orderRepositoryMap = orderRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // 학과로 구분해 orderId로 DAO 찾아서 반환
    public OrderDTO exec(UUID boothId, UUID orderId){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.exec(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        OrderRepository<?> orderRepository = orderRepositoryMap.get(boothName);
        
        // OrderId로 해당 DAO 찾아서
        AbstractOrderDAO dao = orderRepository.findByOrderId(orderId);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);
        
        // OrderDTO로 변환해 반환
        return OrderDTO.fromAbstractOrderDAO(dao);

    }

}
