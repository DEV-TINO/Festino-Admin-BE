package com.DevTino.festino_admin.notice.repository;

import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface NoticeRepositoryJPA extends JpaRepository<NoticeDAO, UUID> {
}
