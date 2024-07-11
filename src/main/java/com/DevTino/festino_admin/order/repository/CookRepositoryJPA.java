package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.CookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CookRepositoryJPA extends JpaRepository<CookDAO, UUID> {
}
