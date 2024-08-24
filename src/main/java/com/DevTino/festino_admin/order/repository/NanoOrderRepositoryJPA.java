package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.NanoOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NanoOrderRepositoryJPA extends JpaRepository<NanoOrderDAO, UUID> {
    // orderId로 주문 검색
    public NanoOrderDAO findByOrderId(UUID orderId);

    // 날짜의 전체 주문 오래된순 검색
    public List<NanoOrderDAO> findByDateOrderByCreateAtAsc(Integer date);

    // OrderType으로 주문 오래된순 검색
    public List<NanoOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date);

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<NanoOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date);

}
