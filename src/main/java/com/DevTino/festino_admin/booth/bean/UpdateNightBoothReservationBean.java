package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothReservationDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothReservationUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothReservationUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateNightBoothReservationBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothReservationDTOBean createNightBoothReservationDTOBean;

    @Autowired
    public UpdateNightBoothReservationBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothReservationDTOBean createNightBoothReservationDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothReservationDTOBean = createNightBoothReservationDTOBean;
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
