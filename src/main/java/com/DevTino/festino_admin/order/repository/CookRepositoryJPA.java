package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.CookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CookRepositoryJPA extends JpaRepository<CookDAO, UUID> {

    // orderId에 해당하는 Cook 검색
    public List<CookDAO> findAllByOrderId(UUID orderId);

    // menuName, isFinish, date에 해당하는 Cook 검색
    public List<CookDAO> findByMenuNameAndIsFinishAndDateOrderByCreateAtDesc(String menuName, Boolean isFinish, Integer date);

    // menuName, date에 해당하는 Cook 검색
    public List<CookDAO> findByMenuNameAndDate(String menuName, Integer date);

}
