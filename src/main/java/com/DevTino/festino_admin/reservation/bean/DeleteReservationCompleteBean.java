package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationCompleteDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationCompleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationCompleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReservationCompleteBean {
    GetReservationDAOBean getReservationDAOBean;
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateReservationCompleteDTOBean createReservationCompleteDTOBean;

    @Autowired
    public DeleteReservationCompleteBean(GetReservationDAOBean getReservationDAOBean, GetNightBoothDAOBean getNightBoothDAOBean, SaveReservationDAOBean saveReservationDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateReservationCompleteDTOBean createReservationCompleteDTOBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createReservationCompleteDTOBean = createReservationCompleteDTOBean;
    }

    // 예약 완료
    public ResponseReservationCompleteUpdateDTO exec(RequestReservationCompleteUpdateDTO requestReservationCompleteUpdateDTO) {
        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationCompleteUpdateDTO.getReservationId(), requestReservationCompleteUpdateDTO.getBoothId());
        if(reservationDAO == null) return null;

        // boothId를 통해 원하는 부스객체 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestReservationCompleteUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // 예약 완료여부 isCancel 값 수정
        reservationDAO.setReservationType(ReservationEnum.COMPLETE);

        // 야간부스 총 예약수 -1
        nightBoothDAO.setTotalReservationNum(nightBoothDAO.getTotalReservationNum()-1);

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createReservationCompleteDTOBean.exec(reservationDAO);
    }
}
