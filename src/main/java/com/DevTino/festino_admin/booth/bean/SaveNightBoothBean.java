package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveNightBoothBean {
    CreateNightBoothDAOBean createNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;

    @Autowired
    public SaveNightBoothBean(CreateNightBoothDAOBean createNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean) {
        this.createNightBoothDAOBean = createNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
    }

    // 야간부스 등록
    public UUID exec(RequestNightBoothSaveDTO requestNightBoothSaveDTO) {

        // 야간부스 DAO 생성
        NightBoothDAO nightBoothDAO = createNightBoothDAOBean.exec(requestNightBoothSaveDTO);

        // DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // 키값 반환
        return nightBoothDAO.getBoothId();
    }
}
