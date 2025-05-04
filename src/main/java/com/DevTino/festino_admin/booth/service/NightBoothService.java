package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.*;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NightBoothService {
    SaveNightBoothBean saveNightBoothBean;
    UpdateNightBoothBean updateNightBoothBean;
    UpdateNightBoothOpenBean updateNightBoothOpenBean;
    UpdateNightBoothOrderBean updateNightBoothOrderBean;
    UpdateNightBoothReservationBean updateNightBoothReservationBean;
    UpdateNightBoothTossPayBean updateNightBoothTossPayBean;
    UpdateNightBoothKakaoPayBean updateNightBoothKakaoPayBean;
    GetNightBoothBean getNightBoothBean;
    GetNightBoothsBean getNightBoothsBean;

    @Autowired
    public NightBoothService(SaveNightBoothBean saveNightBoothBean, UpdateNightBoothBean updateNightBoothBean, UpdateNightBoothOpenBean updateNightBoothOpenBean, UpdateNightBoothOrderBean updateNightBoothOrderBean, UpdateNightBoothReservationBean updateNightBoothReservationBean, UpdateNightBoothTossPayBean updateNightBoothTossPayBean, UpdateNightBoothKakaoPayBean updateNightBoothKakaoPayBean, GetNightBoothBean getNightBoothBean, GetNightBoothsBean getNightBoothsBean) {
        this.saveNightBoothBean = saveNightBoothBean;
        this.updateNightBoothBean = updateNightBoothBean;
        this.updateNightBoothOpenBean = updateNightBoothOpenBean;
        this.updateNightBoothOrderBean = updateNightBoothOrderBean;
        this.updateNightBoothReservationBean = updateNightBoothReservationBean;
        this.updateNightBoothTossPayBean = updateNightBoothTossPayBean;
        this.updateNightBoothKakaoPayBean = updateNightBoothKakaoPayBean;
        this.getNightBoothBean = getNightBoothBean;
        this.getNightBoothsBean = getNightBoothsBean;
    }

    // 야간부스 등록
    public UUID saveNightBooth(RequestNightBoothSaveDTO requestNightBoothSaveDTO) {
        return saveNightBoothBean.exec(requestNightBoothSaveDTO);
    }

    // 야간부스 수정
    public UUID updateNightBooth(RequestNightBoothUpdateDTO requestNightBoothUpdateDTO) {
        return updateNightBoothBean.exec(requestNightBoothUpdateDTO);
    }

    // 야간부스 운영 중 여부 수정
    public ResponseNightBoothOpenUpdateDTO updateNightBoothOpen(RequestNightBoothOpenUpdateDTO requestNightBoothOpenUpdateDTO) {
        return updateNightBoothOpenBean.exec(requestNightBoothOpenUpdateDTO);
    }

    // 야간부스 주문가능 여부 수정
    public ResponseNightBoothOrderUpdateDTO updateNightBoothOrder(RequestNightBoothOrderUpdateDTO requestNightBoothOrderUpdateDTO) {
        return updateNightBoothOrderBean.exec(requestNightBoothOrderUpdateDTO);
    }

    // 야간부스 예약가능 여부 수정
    public ResponseNightBoothReservationUpdateDTO updateNightBoothReservation(RequestNightBoothReservationUpdateDTO requestNightBoothReservationUpdateDTO) {
        return updateNightBoothReservationBean.exec(requestNightBoothReservationUpdateDTO);
    }

    // 야간부스 토스페이 가능 여부 수정
    public ResponseNightBoothTossPayUpdateDTO updateNightBoothTossPay(RequestNightBoothTossPayUpdateDTO requestNightBoothTossPayUpdateDTO) {
        return updateNightBoothTossPayBean.exec(requestNightBoothTossPayUpdateDTO);
    }

    // 야간부스 카카오페이 가능 여부 수정
    public ResponseNightBoothKakaoPayUpdateDTO updateNightBoothKakaoPay(RequestNightBoothKakaoPayUpdateDTO requestNightBoothKakaoPayUpdateDTO) {
        return updateNightBoothKakaoPayBean.exec(requestNightBoothKakaoPayUpdateDTO);
    }

    // 야간부스 조회
    public ResponseNightBoothGetDTO getNightBooth(UUID boothId) {
        return getNightBoothBean.exec(boothId);
    }

    // 야간부스 전체조회
    public List<ResponseNightBoothsGetDTO> getNightBoothAll() {
        return getNightBoothsBean.exec();
    }
}
