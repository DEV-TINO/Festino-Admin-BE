package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.reservation.bean.small.CreateReservationRestoreDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationRestoreDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationRestoreDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReservationRestoreBean {
    GetReservationDAOBean getReservationDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    CreateReservationRestoreDTOBean createReservationRestoreDTOBean;

    @Autowired
    public SaveReservationRestoreBean(GetReservationDAOBean getReservationDAOBean, SaveReservationDAOBean saveReservationDAOBean, CreateReservationRestoreDTOBean createReservationRestoreDTOBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.createReservationRestoreDTOBean = createReservationRestoreDTOBean;
    }

    public ResponseReservationRestoreDTO exec(RequestReservationRestoreDTO requestReservationRestoreDTO) {
        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationRestoreDTO.getReservationId(), requestReservationRestoreDTO.getBoothId());
        if(reservationDAO == null) return null;

        // 예약 복구여부 isCancel 값 수정
        if(reservationDAO.getIsCancel() && requestReservationRestoreDTO.getIsCancel())
            reservationDAO.setIsCancel(false);
        else
            return null;

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);

        // DTO 생성해서 반환
        return createReservationRestoreDTOBean.exec(reservationDAO);
    }
}
