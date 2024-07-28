package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryJPA extends JpaRepository<OrderDAO, UUID> {

    OrderDAO findByOrderId(UUID orderId);

    // 해당 날짜의 전체 주문 최신순 검색
    public List<OrderDAO> findByDateOrderByCreateAtDesc(Integer date);

    // OrderType으로 주문 최신순 검색
    public List<OrderDAO> findByOrderTypeAndDateOrderByCreateAtDesc(OrderType orderType, Integer date);

    // isDeposit, OrderType, date로 주문 최신순 검색
    public List<OrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtDesc(Boolean isDeposit, OrderType orderType, Integer date);
    
}
