package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationDTOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateReservationBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateReservationDTOBean createReservationDTOBean;

    @Autowired
    public UpdateReservationBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateReservationDTOBean createReservationDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createReservationDTOBean = createReservationDTOBean;
    }

    // 예약 가능여부 수정
    public ResponseReservationUpdateDTO exec(RequestReservationUpdateDTO requestReservationUpdateDTO) {
        // boothId를 통해 원하는 야간부스 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestReservationUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // 야간부스 테이블 isReservation 필드 수정
        if(requestReservationUpdateDTO.getIsReservation() == nightBoothDAO.getIsReservation())
            nightBoothDAO.setIsReservation(!nightBoothDAO.getIsReservation());
        else
            return null;

        // 수정된 DAO 값 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createReservationDTOBean.exec(nightBoothDAO);
    }
}
