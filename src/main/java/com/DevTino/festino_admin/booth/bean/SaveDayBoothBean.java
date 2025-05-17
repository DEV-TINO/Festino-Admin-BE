package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateDayBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveDayBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveDayBoothBean {
    CreateDayBoothDAOBean createDayBoothDAOBean;
    SaveDayBoothDAOBean saveDayBoothDAOBean;

    @Autowired
    public SaveDayBoothBean(CreateDayBoothDAOBean createDayBoothDAOBean, SaveDayBoothDAOBean saveDayBoothDAOBean) {
        this.createDayBoothDAOBean = createDayBoothDAOBean;
        this.saveDayBoothDAOBean = saveDayBoothDAOBean;
    }

    // 주간부스 등록
    public UUID exec(RequestDayBoothSaveDTO requestDayBoothSaveDTO) {

        // 주간부스 DAO 생성
        DayBoothDAO dayBoothDAO = createDayBoothDAOBean.exec(requestDayBoothSaveDTO);

        // 주간부스 저장
        saveDayBoothDAOBean.exec(dayBoothDAO);

        // 키값 반환
        return dayBoothDAO.getBoothId();
    }
}
