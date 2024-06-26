package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.SaveDayBoothBean;
import com.DevTino.festino_admin.booth.bean.UpdateDayBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DayBoothService {
    SaveDayBoothBean saveDayBoothBean;
    UpdateDayBoothBean updateDayBoothBean;

    @Autowired
    public DayBoothService(SaveDayBoothBean saveDayBoothBean, UpdateDayBoothBean updateDayBoothBean) {
        this.saveDayBoothBean = saveDayBoothBean;
        this.updateDayBoothBean = updateDayBoothBean;
    }

    // 주간부스 등록
    public UUID saveDayBooth(RequestDayBoothSaveDTO requestDayBoothSaveDTO) {
        return saveDayBoothBean.exec(requestDayBoothSaveDTO);
    }

    //주간부스 수정
    public UUID updateDayBooth(RequestDayBoothUpdateDTO requestDayBoothUpdateDTO) {
        return updateDayBoothBean.exec(requestDayBoothUpdateDTO);
    }
}
