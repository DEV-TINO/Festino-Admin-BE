package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodBoothRepository extends JpaRepository<FoodBoothDAO, UUID> {
}
