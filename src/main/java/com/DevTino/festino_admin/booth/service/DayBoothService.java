package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.*;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DayBoothService {
    SaveDayBoothBean saveDayBoothBean;
    UpdateDayBoothBean updateDayBoothBean;
    UpdateDayBoothOpenBean updateDayBoothOpenBean;
    GetDayBoothBean getDayBoothBean;
    GetDayBoothsBean getDayBoothsBean;

    @Autowired
    public DayBoothService(SaveDayBoothBean saveDayBoothBean, UpdateDayBoothBean updateDayBoothBean, UpdateDayBoothOpenBean updateDayBoothOpenBean, GetDayBoothBean getDayBoothBean, GetDayBoothsBean getDayBoothsBean) {
        this.saveDayBoothBean = saveDayBoothBean;
        this.updateDayBoothBean = updateDayBoothBean;
        this.updateDayBoothOpenBean = updateDayBoothOpenBean;
        this.getDayBoothBean = getDayBoothBean;
        this.getDayBoothsBean = getDayBoothsBean;
    }

    // 주간부스 등록
    public UUID saveDayBooth(RequestDayBoothSaveDTO requestDayBoothSaveDTO) {
        return saveDayBoothBean.exec(requestDayBoothSaveDTO);
    }

    // 주간부스 수정
    public UUID updateDayBooth(RequestDayBoothUpdateDTO requestDayBoothUpdateDTO) {
        return updateDayBoothBean.exec(requestDayBoothUpdateDTO);
    }

    // 주간부스 운영 중 여부 수정
    public ResponseDayBoothOpenUpdateDTO updateDayBoothOpen(RequestDayBoothOpenUpdateDTO requestDayBoothOpenUpdateDTO) {
        return updateDayBoothOpenBean.exec(requestDayBoothOpenUpdateDTO);
    }

    // 주간부스 조회
    public ResponseDayBoothGetDTO getDayBooth(UUID boothId) {
        return getDayBoothBean.exec(boothId);
    }

    // 주간부스 전체조회
    public List<ResponseDayBoothsGetDTO> getDayBoothAll() {
        return getDayBoothsBean.exec();
    }
}
