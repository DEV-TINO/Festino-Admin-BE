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
    CheckReservationDAOBean checkReservationDAOBean;

    @Autowired
    public GetReservationsDAOBean(ReservationRepositoryJPA reservationRepositoryJPA, CheckReservationDAOBean checkReservationDAOBean) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
        this.checkReservationDAOBean = checkReservationDAOBean;
    }

    // boothId를 통해 원하는 부스 전체 DAO 오래된 순으로 반환
    @Transactional(readOnly = true)
    public List<ReservationDAO> exec(UUID boothId, String type) {
        // 예약 리스트 생성
        List<ReservationDAO> reservationDAOList;

        // 부스의 오픈 시간을 활용하여 몇일차인지 구분
        Integer date = checkReservationDAOBean.exec(boothId);

        // 예약 목록일 때
        if (type.equals("all"))
            reservationDAOList = reservationRepositoryJPA.findAllByBoothIdAndIsCancelAndDateOrderByUpdateAtAsc(boothId, false, date);

        // 삭제 목록일 때
        else if(type.equals("cancel"))
            reservationDAOList = reservationRepositoryJPA.findAllByBoothIdAndIsCancelAndDateOrderByUpdateAtAsc(boothId, true, date);

        else
            reservationDAOList = null;

        return reservationDAOList;
    }
}
