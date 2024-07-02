package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.GetNightBoothBean;
import com.DevTino.festino_admin.booth.bean.SaveNightBoothBean;
import com.DevTino.festino_admin.booth.bean.UpdateNightBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NightBoothService {
    SaveNightBoothBean saveNightBoothBean;
    UpdateNightBoothBean updateNightBoothBean;
    GetNightBoothBean getNightBoothBean;

    @Autowired
    public NightBoothService(SaveNightBoothBean saveNightBoothBean, UpdateNightBoothBean updateNightBoothBean, GetNightBoothBean getNightBoothBean) {
        this.saveNightBoothBean = saveNightBoothBean;
        this.updateNightBoothBean = updateNightBoothBean;
        this.getNightBoothBean = getNightBoothBean;
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
    public ResponseNightBoothOpenGetGTO updateNightBoothOpen(RequestNightBoothOpenUpdateDTO requestNightBoothOpenUpdateDTO) {
        return updateNightBoothBean.exec(requestNightBoothOpenUpdateDTO);
    }

    // 야간부스 조회
    public ResponseNightBoothGetDTO getNightBooth(UUID boothId) {
        return getNightBoothBean.exec(boothId);
    }
}
