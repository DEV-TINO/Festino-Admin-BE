package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetNightBoothBean {
    GetNightBoothDAOBean getNightBoothDAOBean;

    @Autowired
    public GetNightBoothBean(GetNightBoothDAOBean getNightBoothDAOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
    }

    public ResponseNightBoothGetDTO exec(UUID boothId) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(boothId);
        if(nightBoothDAO == null) return null;

        // DTO 생성해서 반환
        return ResponseNightBoothGetDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .boothName(nightBoothDAO.getBoothName())
                .boothIntro(nightBoothDAO.getBoothIntro())
                .boothImage(nightBoothDAO.getBoothImage())
                .adminName(nightBoothDAO.getAdminName())
                .descriptImage(nightBoothDAO.getDescriptImage())
                .description(nightBoothDAO.getDescription())
                .location(nightBoothDAO.getLocation())
                .openTime(nightBoothDAO.getOpenTime())
                .closeTime(nightBoothDAO.getCloseTime())
                .isOpen(nightBoothDAO.getIsOpen())
                .isOrder(nightBoothDAO.getIsOrder())
                .totalReservationNum(nightBoothDAO.getTotalReservationNum())
                .build();
    }
}
