package com.DevTino.festino_admin.reservation.service;

import com.DevTino.festino_admin.reservation.bean.GetReservationsBean;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {
    GetReservationsBean getReservationsBean;

    @Autowired
    public ReservationService(GetReservationsBean getReservationsBean) {
        this.getReservationsBean = getReservationsBean;
    }

    // 예약 전체조회
    public ResponseReservationsGetDTO getReservationAll(UUID boothId) {
        return getReservationsBean.exec(boothId);
    }
}
