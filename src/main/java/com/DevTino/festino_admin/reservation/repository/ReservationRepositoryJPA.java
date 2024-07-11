package com.DevTino.festino_admin.reservation.repository;

import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepositoryJPA extends JpaRepository<ReservationDAO, UUID> {
    // boothId를 통해 오래된 순으로 전체 예약 찾기
    List<ReservationDAO> findAllByBoothIdOrderByUpdateAtAsc(UUID boothId);
}
