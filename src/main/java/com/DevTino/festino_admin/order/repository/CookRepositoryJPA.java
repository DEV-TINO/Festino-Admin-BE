package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.CookDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CookRepositoryJPA extends JpaRepository<CookDAO, UUID> {

    // orderId에 해당하는 Cook 검색
    public List<CookDAO> findAllByOrderId(UUID orderId);

    // menuName에 해당하는 Cook 검색
    public List<CookDAO> findByMenuNameAndIsFinishOrderByCreateAtDesc(String menuName, Boolean isFinish);

}
