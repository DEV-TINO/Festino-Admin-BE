package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateNightBoothBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;

    @Autowired
    public UpdateNightBoothBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
    }

    // 야간부스 수정
    public UUID exec(RequestNightBoothUpdateDTO requestNightBoothUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // DAO 수정
        nightBoothDAO.setBoothName(requestNightBoothUpdateDTO.getBoothName());
        nightBoothDAO.setBoothImage(requestNightBoothUpdateDTO.getBoothImage());
        nightBoothDAO.setBoothIntro(requestNightBoothUpdateDTO.getBoothIntro());
        nightBoothDAO.setAdminName(requestNightBoothUpdateDTO.getAdminName());
        nightBoothDAO.setOpenTime(requestNightBoothUpdateDTO.getOpenTime());
        nightBoothDAO.setCloseTime(requestNightBoothUpdateDTO.getCloseTime());
        nightBoothDAO.setDescriptImage(requestNightBoothUpdateDTO.getDescriptImage());
        nightBoothDAO.setDescription(requestNightBoothUpdateDTO.getDescription());
        nightBoothDAO.setLocation(requestNightBoothUpdateDTO.getLocation());
        nightBoothDAO.setIsOpen(requestNightBoothUpdateDTO.getIsOpen());
        nightBoothDAO.setIsOrder(requestNightBoothUpdateDTO.getIsOrder());

        nightBoothDAO.setUpdateAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // 키값 반환
        return nightBoothDAO.getBoothId();
    }
}
