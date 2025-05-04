package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.bean.small.*;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class UpdateNightBoothBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;

    @Autowired
    public UpdateNightBoothBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothOpenDTOBean createNightBoothOpenDTOBean, CreateNightBoothOrderDTOBean createNightBoothOrderDTOBean, CreateNightBoothReservationDTOBean createNightBoothReservationDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
    }

    // 야간부스 수정
    public UUID exec(RequestNightBoothUpdateDTO requestNightBoothUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // 부스 이미지를 넣지 않았을 때 빈값으로 넣어주는 예외처리
        List<String> boothImage = new ArrayList<>();
        if (requestNightBoothUpdateDTO.getBoothImage().isEmpty())
            boothImage = Collections.singletonList("");
        else
            boothImage = requestNightBoothUpdateDTO.getBoothImage();

        // DAO 수정
        nightBoothDAO.setBoothName(requestNightBoothUpdateDTO.getBoothName());
        nightBoothDAO.setBoothImage(boothImage);
        nightBoothDAO.setBoothIntro(requestNightBoothUpdateDTO.getBoothIntro());
        nightBoothDAO.setAdminName(requestNightBoothUpdateDTO.getAdminName());
        nightBoothDAO.setAdminCategory(requestNightBoothUpdateDTO.getAdminCategory());
        nightBoothDAO.setOpenTime(requestNightBoothUpdateDTO.getOpenTime());
        nightBoothDAO.setCloseTime(requestNightBoothUpdateDTO.getCloseTime());
        nightBoothDAO.setIsOpen(requestNightBoothUpdateDTO.getIsOpen());
        nightBoothDAO.setIsOrder(requestNightBoothUpdateDTO.getIsOrder());
        nightBoothDAO.setIsReservation(requestNightBoothUpdateDTO.getIsReservation());
        nightBoothDAO.setAccountInfo(requestNightBoothUpdateDTO.getAccountInfo());
        nightBoothDAO.setIsTossPay(requestNightBoothUpdateDTO.getIsTossPay());
        nightBoothDAO.setIsKakaoPay(requestNightBoothUpdateDTO.getIsKakaoPay());
        nightBoothDAO.setTossPay(requestNightBoothUpdateDTO.getTossPay());
        nightBoothDAO.setKakaoPay(requestNightBoothUpdateDTO.getKakaoPay());

        nightBoothDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // 키값 반환
        return nightBoothDAO.getBoothId();
    }
}
