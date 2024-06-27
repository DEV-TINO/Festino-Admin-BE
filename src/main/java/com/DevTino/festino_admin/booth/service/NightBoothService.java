package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.SaveNightBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NightBoothService {
    SaveNightBoothBean saveNightBoothBean;

    @Autowired
    public NightBoothService(SaveNightBoothBean saveNightBoothBean) {
        this.saveNightBoothBean = saveNightBoothBean;
    }

    // 야간부스 등록
    public UUID saveNightBooth(RequestNightBoothSaveDTO requestNightBoothSaveDTO) {
        return saveNightBoothBean.exec(requestNightBoothSaveDTO);
    }
}
