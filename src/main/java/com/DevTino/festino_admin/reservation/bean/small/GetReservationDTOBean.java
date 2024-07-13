package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.repository.ReservationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetReservationDTOBean {
    ReservationRepositoryJPA reservationRepositoryJPA;

    @Autowired
    public GetReservationDTOBean(ReservationRepositoryJPA reservationRepositoryJPA) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
    }

    // reservationId와 boothId를 통해 원하는 객체 찾기
    public ReservationDAO exec(UUID reservationId, UUID boothId) {
        return reservationRepositoryJPA.findByReservationIdAndBoothId(reservationId, boothId);
    }
}
