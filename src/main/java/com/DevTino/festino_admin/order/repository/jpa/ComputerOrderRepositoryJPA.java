package com.DevTino.festino_admin.order.repository.jpa;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ComputerOrderRepositoryJPA extends JpaRepository<ComputerOrderDAO, UUID> {
    // orderId로 주문 검색
    public ComputerOrderDAO findByOrderId(UUID orderId);

    // 날짜의 전체 주문 오래된순 검색
    public List<ComputerOrderDAO> findByDateOrderByCreateAtAsc(Integer date);

    // OrderType으로 주문 오래된순 검색
    public List<ComputerOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date);

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<ComputerOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date);

}
