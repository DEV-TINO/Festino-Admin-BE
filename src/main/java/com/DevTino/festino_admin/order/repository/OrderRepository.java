package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.OrderType;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {

    // DTO 받아서 DAO로 변환해 저장
    public void save(OrderDTO orderDTO);

    // orderId로 주문 검색
    public AbstractOrderDAO findByOrderId(UUID orderId);

    // 날짜의 전체 주문 오래된순 검색
    public List<AbstractOrderDAO> findByDateOrderByCreateAtAsc(Integer date);

    // OrderType으로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date);

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date);

}
