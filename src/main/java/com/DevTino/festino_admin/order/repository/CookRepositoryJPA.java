package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.CookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CookRepositoryJPA extends JpaRepository<CookDAO, UUID> {

    // orderId에 해당하는 Cook 검색
    public List<CookDAO> findAllByOrderId(UUID orderId);

    // boothId, menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<CookDAO> findByBoothIdAndMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID boothId, UUID menuId, Boolean isFinish, Integer date);

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<CookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish);

}
