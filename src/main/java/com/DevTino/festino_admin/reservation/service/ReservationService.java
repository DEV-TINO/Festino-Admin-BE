package com.DevTino.festino_admin.reservation.service;

import com.DevTino.festino_admin.reservation.bean.*;
import com.DevTino.festino_admin.reservation.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class ReservationService {
    GetReservationsBean getReservationsBean;
    DeleteReservationCancelBean deleteReservationCancelBean;
    DeleteReservationCompleteBean deleteReservationCompleteBean;
    SaveReservationRestoreBean saveReservationRestoreBean;
    UpdateReservationBean updateReservationBean;

    @Autowired
    public ReservationService(GetReservationsBean getReservationsBean, DeleteReservationCancelBean deleteReservationCancelBean, DeleteReservationCompleteBean deleteReservationCompleteBean, SaveReservationRestoreBean saveReservationRestoreBean, UpdateReservationBean updateReservationBean) {
        this.getReservationsBean = getReservationsBean;
        this.deleteReservationCancelBean = deleteReservationCancelBean;
        this.deleteReservationCompleteBean = deleteReservationCompleteBean;
        this.saveReservationRestoreBean = saveReservationRestoreBean;
        this.updateReservationBean = updateReservationBean;
    }

    // 예약 전체조회
    public ResponseReservationsGetDTO getReservationAll(UUID boothId, String type) {
        return getReservationsBean.exec(boothId, type);
    }

    // 예약 삭제
    public ResponseReservationDeleteDTO deleteReservation(RequestReservationDeleteDTO requestReservationDeleteDTO) throws IOException {
        return deleteReservationCancelBean.exec(requestReservationDeleteDTO);
    }

    // 예약 완료
    public ResponseReservationCompleteUpdateDTO completeReservation(RequestReservationCompleteUpdateDTO requestReservationCompleteUpdateDTO) throws IOException {
        return deleteReservationCompleteBean.exec(requestReservationCompleteUpdateDTO);
    }

    // 예약 복구
    public ResponseReservationRestoreUpdateDTO restoreReservation(RequestReservationRestoreUpdateDTO requestReservationRestoreUpdateDTO) {
        return saveReservationRestoreBean.exec(requestReservationRestoreUpdateDTO);
    }

    // 예약 가능여부 수정
    public ResponseReservationUpdateDTO updateReservation(RequestReservationUpdateDTO requestReservationUpdateDTO) {
        return updateReservationBean.exec(requestReservationUpdateDTO);
    }
}
