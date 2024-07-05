package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepositoryJPA extends JpaRepository<OrderDAO, UUID> {
}
