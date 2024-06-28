package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DayBoothRepository extends JpaRepository<DayBoothDAO, UUID> {
}
