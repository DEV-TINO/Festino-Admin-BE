package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.repository.ReservationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class GetReservationsDAOBean {
    ReservationRepositoryJPA reservationRepositoryJPA;

    @Autowired
    public GetReservationsDAOBean(ReservationRepositoryJPA reservationRepositoryJPA) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
    }

    // boothId를 통해 원하는 부스 전체 DAO 오래된 순으로 반환
    @Transactional(readOnly = true)
    public List<ReservationDAO> exec(UUID boothId, String type) {
        List<ReservationDAO> reservationDAOList;

        // 예약 목록일 때
        if (type.equals("all"))
            reservationDAOList = reservationRepositoryJPA.findAllByBoothIdAndIsCancelOrderByUpdateAtAsc(boothId, false);

        // 삭제 목록일 때
        else if(type.equals("cancel"))
            reservationDAOList = reservationRepositoryJPA.findAllByBoothIdAndIsCancelOrderByUpdateAtAsc(boothId, true);

        else
            reservationDAOList = null;

        return reservationDAOList;
    }
}
