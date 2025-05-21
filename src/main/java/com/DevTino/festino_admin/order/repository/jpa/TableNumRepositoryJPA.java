package com.DevTino.festino_admin.order.repository.jpa;

import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TableNumRepositoryJPA extends JpaRepository<TableNumDAO, Integer> {

    List<TableNumDAO> findAllByBoothIdOrderByTableNumIndexAsc(UUID boothId);

    void deleteAllByBoothId(UUID boothId);

    // 부스 아이디와 isDeleted 가 false인 테이블 전체 조회
    List<TableNumDAO> findAllByBoothIdAndIsDeletedFalseOrderByTableNumIndexAsc(UUID boothId);
}
