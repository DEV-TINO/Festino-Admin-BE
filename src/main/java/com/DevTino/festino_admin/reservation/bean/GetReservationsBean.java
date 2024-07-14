package com.DevTino.festino_admin.reservation.bean;

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
    GetReservationsDAOBean getReservationsDAOBean;
    CreateReservationsDTOBean createReservationsDTOBean;

    @Autowired
    public GetReservationsBean(GetReservationsDAOBean getReservationsDAOBean, CreateReservationsDTOBean createReservationsDTOBean) {
        this.getReservationsDAOBean = getReservationsDAOBean;
        this.createReservationsDTOBean = createReservationsDTOBean;
    }

    // 예약 전체 조회
    public ResponseReservationsGetDTO exec(UUID boothId, String type) {
        // boothId를 통해 원하는 부스의 전체 예약 DAO 오래된 순서로 찾기(삭제된 예약인지 아닌지 type(all/cancel) 으로 구별하여 찾기)
        List<ReservationDAO> reservationDAOList = getReservationsDAOBean.exec(boothId, type);
        if(reservationDAOList.isEmpty()) return null;

        // DAO 리스트를 DTO 리스트 생성해서 반환
        return createReservationsDTOBean.exec(reservationDAOList, boothId);
    }
}
