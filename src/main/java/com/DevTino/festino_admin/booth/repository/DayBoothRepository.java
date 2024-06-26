package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DayBoothRepository extends JpaRepository<DayBoothDAO, UUID> {
}
