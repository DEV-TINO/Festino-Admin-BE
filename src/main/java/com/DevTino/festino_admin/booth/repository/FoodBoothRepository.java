package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodBoothRepository extends JpaRepository<FoodBoothDAO, UUID> {
}
