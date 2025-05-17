package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GetAllTableOrderDAOBean {

    private final Map<String, OrderRepository<?>> orderRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetAllTableOrderDAOBean(Map<String, OrderRepository<?>> orderRepositoryMap, BoothNameResolver boothNameResolver){
        this.orderRepositoryMap = orderRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }


    // date필드와 일치하는 객체의 최근 한시간 주문 내역 조회 TableNumIndex 오름차순, CreateAt 오름차순
    public List<OrderDTO> exec(UUID boothId, Integer date){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.exec(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        OrderRepository<?> orderRepository = orderRepositoryMap.get(boothName);

        // OrderDAO 리스트 조회
        LocalDateTime after= LocalDateTime.now().minusHours(1);
        List<? extends AbstractOrderDAO> orderDAOList = orderRepository.findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(date, after);
        if (orderDAOList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        // OrderDAO 리스트를 OrderDTO 리스트로 변환해 반환
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (AbstractOrderDAO dao : orderDAOList) { orderDTOList.add(OrderDTO.fromAbstractOrderDAO(dao)); }
        return orderDTOList;

    }
}
