package com.DevTino.festino_admin.reservation.service;

import com.DevTino.festino_admin.reservation.bean.GetReservationsBean;
import com.DevTino.festino_admin.reservation.bean.UpdateReservationBean;
import com.DevTino.festino_admin.reservation.bean.DeleteReservationBean;
import com.DevTino.festino_admin.reservation.bean.SaveReservationRestoreBean;
import com.DevTino.festino_admin.reservation.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {
    GetReservationsBean getReservationsBean;
    DeleteReservationBean deleteReservationBean;
    SaveReservationRestoreBean saveReservationRestoreBean;
    UpdateReservationBean updateReservationBean;

    @Autowired
    public ReservationService(GetReservationsBean getReservationsBean, DeleteReservationBean deleteReservationBean, SaveReservationRestoreBean saveReservationRestoreBean, UpdateReservationBean updateReservationBean) {
        this.getReservationsBean = getReservationsBean;
        this.deleteReservationBean = deleteReservationBean;
        this.saveReservationRestoreBean = saveReservationRestoreBean;
        this.updateReservationBean = updateReservationBean;
    }

    // 예약 전체조회
    public ResponseReservationsGetDTO getReservationAll(UUID boothId, String type) {
        return getReservationsBean.exec(boothId, type);
    }

    // 예약 삭제
    public ResponseReservationDeleteDTO deleteReservation(RequestReservationDeleteDTO requestReservationDeleteDTO) {
        return deleteReservationBean.exec(requestReservationDeleteDTO);
    }

    // 예약 복구
    public ResponseReservationRestoreDTO restoreReservation(RequestReservationRestoreDTO requestReservationRestoreDTO) {
        return saveReservationRestoreBean.exec(requestReservationRestoreDTO);
    }

    // 예약 가능여부 수정
    public ResponseReservationUpdateDTO updateReservation(RequestReservationUpdateDTO requestReservationUpdateDTO) {
        return updateReservationBean.exec(requestReservationUpdateDTO);
    }
}
