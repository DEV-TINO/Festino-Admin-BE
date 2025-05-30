package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.bean.small.CheckReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationsDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationsDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetReservationsBean {

    GetNightBoothDAOBean getNightBoothDAOBean;
    GetReservationsDAOBean getReservationsDAOBean;
    CreateReservationsDTOBean createReservationsDTOBean;
    CheckReservationDAOBean checkReservationDAOBean;

    @Autowired
    public GetReservationsBean(GetNightBoothDAOBean getNightBoothDAOBean, GetReservationsDAOBean getReservationsDAOBean, CreateReservationsDTOBean createReservationsDTOBean, CheckReservationDAOBean checkReservationDAOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.getReservationsDAOBean = getReservationsDAOBean;
        this.createReservationsDTOBean = createReservationsDTOBean;
        this.checkReservationDAOBean = checkReservationDAOBean;
    }

    // 예약 전체 조회
    public ResponseReservationsGetDTO exec(UUID boothId, String type) {

        // boothId를 통해 원하는 야간부스 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(boothId);

        // date를 통해 날짜를 구분해 조회
        // 부스의 오픈 시간을 활용하여 몇일차인지 구분
        Integer date = checkReservationDAOBean.exec(nightBoothDAO);

        // boothId를 통해 원하는 부스의 전체 예약 DAO 오래된 순서로 찾기
        // 삭제된 예약인지 아닌지 type(all/cancel) 으로 구별하여 찾기
        List<ReservationDAO> reservationDAOList = getReservationsDAOBean.exec(boothId, date);

        // DAO 리스트를 DTO 리스트 생성해서 반환
        return createReservationsDTOBean.exec(type, nightBoothDAO, reservationDAOList);
    }
}
