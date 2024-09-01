package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.MachineCookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MachineCookRepositoryJPA extends JpaRepository<MachineCookDAO, UUID> {
    // orderId에 해당하는 Cook 검색
    public List<MachineCookDAO> findAllByOrderId(UUID orderId);

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<MachineCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<MachineCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<MachineCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish);
}
