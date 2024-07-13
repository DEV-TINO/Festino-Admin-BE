package com.DevTino.festino_admin.reservation.service;

import com.DevTino.festino_admin.reservation.bean.GetReservationsBean;
import com.DevTino.festino_admin.reservation.bean.UpdateReservationDeleteBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {
    GetReservationsBean getReservationsBean;
    UpdateReservationDeleteBean updateReservationDeleteBean;

    @Autowired
    public ReservationService(GetReservationsBean getReservationsBean, UpdateReservationDeleteBean updateReservationDeleteBean) {
        this.getReservationsBean = getReservationsBean;
        this.updateReservationDeleteBean = updateReservationDeleteBean;
    }

    // 예약 전체조회
    public ResponseReservationsGetDTO getReservationAll(UUID boothId) {
        return getReservationsBean.exec(boothId);
    }

    // 예약 삭제
    public ResponseReservationDeleteUpdateDTO updateReservationDelete(RequestReservationDeleteUpdateDTO requestReservationDeleteUpdateDTO) {
        return  updateReservationDeleteBean.exec(requestReservationDeleteUpdateDTO);
    }
}
