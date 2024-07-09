package com.DevTino.festino_admin.show.talent.repository;

import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TalentShowRepositoryJPA extends JpaRepository<TalentShowDAO, UUID> {
}
