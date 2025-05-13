package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import com.DevTino.festino_admin.reservation.repository.ReservationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetReservationDAOBean {
    ReservationRepositoryJPA reservationRepositoryJPA;

    @Autowired
    public GetReservationDAOBean(ReservationRepositoryJPA reservationRepositoryJPA) {
        this.reservationRepositoryJPA = reservationRepositoryJPA;
    }

    // reservationId와 boothId를 통해 원하는 객체 찾기
    public ReservationDAO exec(UUID reservationId, UUID boothId) {

        ReservationDAO dao = reservationRepositoryJPA.findByReservationIdAndBoothId(reservationId, boothId);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // 전화번호 기준으로 예약된 내역 조회
    public ReservationDAO exec(String phoneNum) {
        return reservationRepositoryJPA.findByPhoneNumAndReservationType(phoneNum, ReservationEnum.RESERVE);
    }
}
