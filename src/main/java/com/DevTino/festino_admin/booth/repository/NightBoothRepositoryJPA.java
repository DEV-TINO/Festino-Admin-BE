package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NightBoothRepositoryJPA extends JpaRepository<NightBoothDAO, UUID> {
    NightBoothDAO findByAdminName(String adminName);
}
