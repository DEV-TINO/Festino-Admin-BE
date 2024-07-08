package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.*;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateNightBoothBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothOpenDTOBean createNightBoothOpenDTOBean;
    CreateNightBoothOrderDTOBean createNightBoothOrderDTOBean;
    CreateNightBoothReservationDTOBean createNightBoothReservationDTOBean;

    @Autowired
    public UpdateNightBoothBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothOpenDTOBean createNightBoothOpenDTOBean, CreateNightBoothOrderDTOBean createNightBoothOrderDTOBean, CreateNightBoothReservationDTOBean createNightBoothReservationDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothOpenDTOBean = createNightBoothOpenDTOBean;
        this.createNightBoothOrderDTOBean = createNightBoothOrderDTOBean;
        this.createNightBoothReservationDTOBean = createNightBoothReservationDTOBean;
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
        nightBoothDAO.setAdminCategory(requestNightBoothUpdateDTO.getAdminCategory());
        nightBoothDAO.setOpenTime(requestNightBoothUpdateDTO.getOpenTime());
        nightBoothDAO.setCloseTime(requestNightBoothUpdateDTO.getCloseTime());
        nightBoothDAO.setLocation(requestNightBoothUpdateDTO.getLocation());
        nightBoothDAO.setIsOpen(requestNightBoothUpdateDTO.getIsOpen());
        nightBoothDAO.setIsOrder(requestNightBoothUpdateDTO.getIsOrder());
        nightBoothDAO.setIsReservation(requestNightBoothUpdateDTO.getIsReservation());

        nightBoothDAO.setUpdateAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // 키값 반환
        return nightBoothDAO.getBoothId();
    }

    // 야간부스 운영 중 여부 수정
    public ResponseNightBoothOpenUpdateDTO exec(RequestNightBoothOpenUpdateDTO requestNightBoothOpenUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothOpenUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // DAO 운영 중 여부 수정
        if(requestNightBoothOpenUpdateDTO.getIsOpen() == nightBoothDAO.getIsOpen())
            nightBoothDAO.setIsOpen(!nightBoothDAO.getIsOpen());
        else
            return null;

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothOpenDTOBean.exec(nightBoothDAO);
    }

    // 야간부스 주문가능 여부 수정
    public ResponseNightBoothOrderUpdateDTO exec(RequestNightBoothOrderUpdateDTO requestNightBoothOrderUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothOrderUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // DAO 주문가능 여부 수정
        if(requestNightBoothOrderUpdateDTO.getIsOrder() == nightBoothDAO.getIsOrder())
            nightBoothDAO.setIsOrder(!nightBoothDAO.getIsOrder());
        else
            return null;

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothOrderDTOBean.exec(nightBoothDAO);
    }

    // 야간부스 예약가능 여부 수정
    public ResponseNightBoothReservationUpdateDTO exec(RequestNightBoothReservationUpdateDTO requestNightBoothReservationUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothReservationUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // DAO 예약가능 여부 수정
        if(requestNightBoothReservationUpdateDTO.getIsReservation() == nightBoothDAO.getIsReservation())
            nightBoothDAO.setIsReservation(!nightBoothDAO.getIsReservation());
        else
            return null;

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothReservationDTOBean.exec(nightBoothDAO);
    }
}
