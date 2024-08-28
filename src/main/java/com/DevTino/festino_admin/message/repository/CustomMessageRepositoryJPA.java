package com.DevTino.festino_admin.message.repository;

import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomMessageRepositoryJPA extends JpaRepository<CustomMessageDAO, Long> {
    List<CustomMessageDAO> findByBoothIdOrderByMessageTypeAsc(UUID boothId);
}
