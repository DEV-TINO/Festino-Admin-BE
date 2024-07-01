package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.GetDayBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveDayBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateDayBoothBean {
    GetDayBoothDAOBean getDayBoothDAOBean;
    SaveDayBoothDAOBean saveDayBoothDAOBean;

    @Autowired
    public UpdateDayBoothBean(GetDayBoothDAOBean getDayBoothDAOBean, SaveDayBoothDAOBean saveDayBoothDAOBean) {
        this.getDayBoothDAOBean = getDayBoothDAOBean;
        this.saveDayBoothDAOBean = saveDayBoothDAOBean;
    }

    public UUID exec(RequestDayBoothUpdateDTO requestDayBoothUpdateDTO) {
        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        DayBoothDAO dayBoothDAO = getDayBoothDAOBean.exec(requestDayBoothUpdateDTO.getBoothId());
        if(dayBoothDAO == null) return null;

        // DAO 수정
        dayBoothDAO.setBoothImage(requestDayBoothUpdateDTO.getBoothImage());
        dayBoothDAO.setBoothIntro(requestDayBoothUpdateDTO.getBoothIntro());
        dayBoothDAO.setBoothName(requestDayBoothUpdateDTO.getBoothName());
        dayBoothDAO.setOpenTime(requestDayBoothUpdateDTO.getOpenTime());
        dayBoothDAO.setCloseTime(requestDayBoothUpdateDTO.getCloseTime());
        dayBoothDAO.setLocation(requestDayBoothUpdateDTO.getLocation());
        dayBoothDAO.setAdminName(requestDayBoothUpdateDTO.getAdminName());
        dayBoothDAO.setAdminCategory(requestDayBoothUpdateDTO.getAdminCategory());
        dayBoothDAO.setIsOpen(requestDayBoothUpdateDTO.getIsOpen());

        dayBoothDAO.setUpdateAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveDayBoothDAOBean.exec(dayBoothDAO);

        // 키값 반환
        return dayBoothDAO.getBoothId();
    }
}
