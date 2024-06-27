package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.SaveNightBoothBean;
import com.DevTino.festino_admin.booth.bean.UpdateNightBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NightBoothService {
    SaveNightBoothBean saveNightBoothBean;
    UpdateNightBoothBean updateNightBoothBean;

    @Autowired
    public NightBoothService(SaveNightBoothBean saveNightBoothBean, UpdateNightBoothBean updateNightBoothBean) {
        this.saveNightBoothBean = saveNightBoothBean;
        this.updateNightBoothBean = updateNightBoothBean;
    }

    // 야간부스 등록
    public UUID saveNightBooth(RequestNightBoothSaveDTO requestNightBoothSaveDTO) {
        return saveNightBoothBean.exec(requestNightBoothSaveDTO);
    }

    // 야간부스 수정
    public UUID updateNightBooth(RequestNightBoothUpdateDTO requestNightBoothUpdateDTO) {
        return updateNightBoothBean.exec(requestNightBoothUpdateDTO);
    }
}
