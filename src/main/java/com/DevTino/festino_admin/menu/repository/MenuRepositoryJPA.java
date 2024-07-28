package com.DevTino.festino_admin.menu.repository;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuRepositoryJPA extends JpaRepository<MenuDAO, UUID> {
    MenuDAO findByMenuIdAndBoothId(UUID menuId, UUID boothId);
    List<MenuDAO> findAllByBoothIdAndIsDeletedOrderByMenuIndexAsc(UUID boothId, Boolean isDeleted);
}
