package com.DevTino.festino_admin.show.club.repository;

import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubShowRepositoryJPA extends JpaRepository<ClubShowDAO, UUID> {
}
