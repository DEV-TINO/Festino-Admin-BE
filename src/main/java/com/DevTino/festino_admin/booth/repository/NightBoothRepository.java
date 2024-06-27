package com.DevTino.festino_admin.booth.repository;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NightBoothRepository extends JpaRepository<NightBoothDAO, UUID> {
}
