package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryJPA extends JpaRepository<OrderDAO, UUID> {

    // 전체 주문 최신순 검색
    public List<OrderDAO> findByOrderByCreateAtDesc();

    // 입금대기 중인 주문 최신순 검색
    public List<OrderDAO> findByIsDepositOrderByCreateAtDesc(Boolean isDeposit);

    // OrderType으로 주문 최신순 검색
    public List<OrderDAO> findByOrderTypeOrderByCreateAtDesc(OrderType orderType);

    // isDeposit, OrderType으로 주문 최신순 검색
    public List<OrderDAO> findByIsDepositAndOrderTypeOrderByCreateAtDesc(Boolean isDeposit, OrderType orderType);
    
}
