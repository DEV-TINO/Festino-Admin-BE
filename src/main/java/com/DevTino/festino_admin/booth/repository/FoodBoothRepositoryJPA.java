package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodBoothRepositoryJPA extends JpaRepository<FoodBoothDAO, UUID> {
    FoodBoothDAO findByAdminName(String adminName);
}
