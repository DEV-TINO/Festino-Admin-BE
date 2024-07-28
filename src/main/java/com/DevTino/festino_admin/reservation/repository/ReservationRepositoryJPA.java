package com.DevTino.festino_admin.reservation.repository;

import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepositoryJPA extends JpaRepository<ReservationDAO, UUID> {

    // 취소되지 않은 데이터 중 이름과 번호, 예약 여부로 예약 내역 확인
    ReservationDAO findByPhoneNumAndReservationType(String phoneNum, ReservationEnum reservationType);

    // boothId를 통해 오래된 순으로 전체 예약 찾기
    List<ReservationDAO> findAllByBoothIdAndDateOrderByUpdateAtAsc(UUID boothId, Integer date);

    // reservationId와 boothId를 통해 원하는 객체 찾기
    ReservationDAO findByReservationIdAndBoothId(UUID reservationId, UUID boothId);

    List<ReservationDAO> findTop2ByReservationTypeAndBoothIdOrderByReservationNumAsc(ReservationEnum reservationType, UUID boothId);
}
