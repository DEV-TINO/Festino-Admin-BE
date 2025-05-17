package com.DevTino.festino_admin.order.repository.jpa;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface OrderRepositoryJPA<T extends AbstractOrderDAO> extends JpaRepository<T, UUID> {

    T findByOrderId(UUID orderId);

    List<T> findByDateOrderByCreateAtAsc(Integer date);

    List<T> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date);

    List<T> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date);

    List<T> findByTableNumOrderByCreateAtAsc(Integer tableNum);

    List<T> findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(Integer date, LocalDateTime after);

}