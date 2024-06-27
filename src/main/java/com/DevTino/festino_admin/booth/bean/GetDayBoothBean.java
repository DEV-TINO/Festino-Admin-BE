package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.GetDayBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDayBoothBean {
    GetDayBoothDAOBean getDayBoothDAOBean;

    @Autowired
    public GetDayBoothBean(GetDayBoothDAOBean getDayBoothDAOBean) {
        this.getDayBoothDAOBean = getDayBoothDAOBean;
    }

    public ResponseDayBoothGetDTO exec(UUID boothId) {
        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        DayBoothDAO dayBoothDAO = getDayBoothDAOBean.exec(boothId);
        if(dayBoothDAO == null) return null;

        // DTO 생성해서 반환
        return ResponseDayBoothGetDTO.builder()
                .boothId(dayBoothDAO.getBoothId())
                .boothIntro(dayBoothDAO.getBoothIntro())
                .boothImage(dayBoothDAO.getBoothImage())
                .boothName(dayBoothDAO.getBoothName())
                .description(dayBoothDAO.getDescription())
                .descriptImage(dayBoothDAO.getDescriptImage())
                .location(dayBoothDAO.getLocation())
                .openTime(dayBoothDAO.getOpenTime())
                .closeTime(dayBoothDAO.getCloseTime())
                .adminName(dayBoothDAO.getAdminName())
                .isOpen(dayBoothDAO.getIsOpen())
                .build();
    }
}
