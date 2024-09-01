package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DesignCookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DesignCookRepositoryJPA extends JpaRepository<DesignCookDAO, UUID> {
    // orderId에 해당하는 Cook 검색
    public List<DesignCookDAO> findAllByOrderId(UUID orderId);

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<DesignCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<DesignCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);
}
