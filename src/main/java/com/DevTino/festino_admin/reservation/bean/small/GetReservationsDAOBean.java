package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
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
    public List<ReservationDAO> exec(UUID boothId, Integer date) {

        List<ReservationDAO> daoList = reservationRepositoryJPA.findAllByBoothIdAndDateOrderByCreateAtAsc(boothId, date);
        if (daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;

    }

    // reservagtionNum 이 오름차순 기준으로 2번째 예약 객체 찾기
    @Transactional(readOnly = true)
    public List<ReservationDAO> exec(UUID boothId) {
        return reservationRepositoryJPA.findTop2ByReservationTypeAndBoothIdOrderByReservationNumAsc(ReservationEnum.RESERVE, boothId);
    }
}
