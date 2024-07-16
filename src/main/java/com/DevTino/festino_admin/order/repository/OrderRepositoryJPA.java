package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryJPA extends JpaRepository<OrderDAO, UUID> {

    // 입금대기 중인 주문 검색
    public List<OrderDAO> findByIsDeposit(Boolean isDeposit);

    // 조리완료 주문 검색
    public List<OrderDAO> findByOrderType(OrderType orderType);
    
}
