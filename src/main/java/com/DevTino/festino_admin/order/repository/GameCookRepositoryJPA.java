package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.GameCookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameCookRepositoryJPA extends JpaRepository<GameCookDAO, UUID> {
    // orderId에 해당하는 Cook 검색
    public List<GameCookDAO> findAllByOrderId(UUID orderId);

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<GameCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<GameCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<GameCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish);
}
