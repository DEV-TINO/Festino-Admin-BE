package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationRestoreDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationRestoreUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationRestoreUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReservationRestoreBean {
    GetReservationDAOBean getReservationDAOBean;
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateReservationRestoreDTOBean createReservationRestoreDTOBean;

    @Autowired
    public SaveReservationRestoreBean(GetReservationDAOBean getReservationDAOBean, GetNightBoothDAOBean getNightBoothDAOBean, SaveReservationDAOBean saveReservationDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateReservationRestoreDTOBean createReservationRestoreDTOBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createReservationRestoreDTOBean = createReservationRestoreDTOBean;
    }

    public ResponseReservationRestoreUpdateDTO exec(RequestReservationRestoreUpdateDTO requestReservationRestoreUpdateDTO) {
        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationRestoreUpdateDTO.getReservationId(), requestReservationRestoreUpdateDTO.getBoothId());
        if(reservationDAO == null) return null;

        // boothId를 통해 원하는 부스객체 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestReservationRestoreUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // 예약 복구여부 변경
        if(reservationDAO.getReservationType().equals(requestReservationRestoreUpdateDTO.getReservationType())) {
            // 예약 복구여부 isCancel 값 수정
            reservationDAO.setReservationType(ReservationEnum.RESERVE);

            // 야간부스 총 예약수 +1
            nightBoothDAO.setTotalReservationNum(nightBoothDAO.getTotalReservationNum()+1);
        }
        else
            return null;

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createReservationRestoreDTOBean.exec(reservationDAO);
    }
}
