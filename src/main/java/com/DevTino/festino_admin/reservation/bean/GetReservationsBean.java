package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.reservation.bean.small.CreateReservationsDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationsDTOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetReservationsBean {
    GetReservationsDTOBean getReservationsDTOBean;
    CreateReservationsDTOBean createReservationsDTOBean;

    @Autowired
    public GetReservationsBean(GetReservationsDTOBean getReservationsDTOBean, CreateReservationsDTOBean createReservationsDTOBean) {
        this.getReservationsDTOBean = getReservationsDTOBean;
        this.createReservationsDTOBean = createReservationsDTOBean;
    }

    // 예약 전체 조회
    public ResponseReservationsGetDTO exec(UUID boothId) {
        // boothId를 통해 원하는 부스의 전체 예약 DAO 오래된 순서로 찾기
        List<ReservationDAO> reservationDAOList = getReservationsDTOBean.exec(boothId);
        if(reservationDAOList.isEmpty()) return null;

        // DAO 리스트를 DTO 리스트 생성해서 반환
        return createReservationsDTOBean.exec(reservationDAOList, boothId);
    }
}
