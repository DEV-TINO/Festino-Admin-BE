package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.NewMaterialCookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NewMaterialCookRepositoryJPA extends JpaRepository<NewMaterialCookDAO, UUID> {
    // orderId에 해당하는 Cook 검색
    public List<NewMaterialCookDAO> findAllByOrderId(UUID orderId);

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<NewMaterialCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<NewMaterialCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);
}
