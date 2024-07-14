package com.DevTino.festino_admin.notice.repository;

import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface NoticeRepositoryJPA extends JpaRepository<NoticeDAO, UUID> {

    // NoticeDAO Pin 우선, 최신순 정렬 검색
    Page<NoticeDAO> findAllByOrderByIsPinDescCreateAtDesc(Pageable pageable);

}
