package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.SaveDayBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DayBoothService {
    SaveDayBoothBean saveDayBoothBean;

    @Autowired
    public DayBoothService(SaveDayBoothBean saveDayBoothBean) {
        this.saveDayBoothBean = saveDayBoothBean;
    }

    // 주간부스 등록
    public UUID saveDayBooth(RequestDayBoothSaveDTO requestDayBoothSaveDTO) {
        return saveDayBoothBean.exec(requestDayBoothSaveDTO);
    }
}
