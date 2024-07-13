package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.repository.ReservationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReservationDAOBean {
    ReservationRepositoryJPA reservationRepositoryJPA;

    @Autowired
    public SaveReservationDAOBean(ReservationRepositoryJPA reservationRepositoryJPA) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
    }

    // 예약 DAO를 DB에 저장
    public void exec(ReservationDAO reservationDAO) {
        reservationRepositoryJPA.save(reservationDAO);
    }
}
