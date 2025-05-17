package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.OrderType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OrderRepository<T extends AbstractOrderDAO> {
    void save(OrderDTO orderDTO);
    T findByOrderId(UUID orderId);
    List<T> findByDateOrderByCreateAtAsc(Integer date);
    List<T> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date);
    List<T> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date);
    List<T> findByTableNumOrderByCreateAtAsc(Integer tableNum);
    List<T> findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(Integer date, LocalDateTime after);
}