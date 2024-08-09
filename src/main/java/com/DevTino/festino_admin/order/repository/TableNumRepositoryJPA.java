package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TableNumRepositoryJPA extends JpaRepository<TableNumDAO, Integer> {

    List<TableNumDAO> findAllByBoothId(UUID boothId);

    void deleteAllByBoothId(UUID boothId);
}
