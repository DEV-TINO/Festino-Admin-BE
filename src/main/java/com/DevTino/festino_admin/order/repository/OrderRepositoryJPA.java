package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryJPA extends JpaRepository<OrderDAO, UUID> {

    // orderId로 주문 검색
    public OrderDAO findByOrderId(UUID orderId);

    // 해당 boothId, 날짜의 전체 주문 최신순 검색
    public List<OrderDAO> findByBoothIdAndDateOrderByCreateAtDesc(UUID boothId, Integer date);

    // boothId, OrderType으로 주문 최신순 검색
    public List<OrderDAO> findByBoothIdAndOrderTypeAndDateOrderByCreateAtDesc(UUID boothId, OrderType orderType, Integer date);

    // boothId, isDeposit, OrderType, date로 주문 최신순 검색
    public List<OrderDAO> findByBoothIdAndIsDepositAndOrderTypeAndDateOrderByCreateAtDesc(UUID boothId, Boolean isDeposit, OrderType orderType, Integer date);
    
}
