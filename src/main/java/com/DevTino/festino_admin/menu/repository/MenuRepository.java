package com.DevTino.festino_admin.menu.repository;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuDAO, UUID> {
}
