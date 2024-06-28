package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NightBoothRepository extends JpaRepository<NightBoothDAO, UUID> {
}
