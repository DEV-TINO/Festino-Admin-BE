package com.DevTino.festino_admin.user.repository;

import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, UUID> {
}
