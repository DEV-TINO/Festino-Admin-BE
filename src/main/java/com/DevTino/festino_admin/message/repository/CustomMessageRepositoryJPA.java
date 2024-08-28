package com.DevTino.festino_admin.message.repository;

import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.domain.ENUM.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomMessageRepositoryJPA extends JpaRepository<CustomMessageDAO, Long> {
    CustomMessageDAO findByBoothIdAndMessageType(UUID boothId, MessageType messageType);
    List<CustomMessageDAO> findByBoothIdOrderByMessageTypeAsc(UUID boothId);
}
