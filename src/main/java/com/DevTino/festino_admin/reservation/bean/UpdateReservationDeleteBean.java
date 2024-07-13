package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.reservation.bean.small.CreateReservationDeleteDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateReservationDeleteBean {
    GetReservationDTOBean getReservationDTOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    CreateReservationDeleteDTOBean createReservationDeleteDTOBean;

    @Autowired
    public UpdateReservationDeleteBean(GetReservationDTOBean getReservationDTOBean, SaveReservationDAOBean saveReservationDAOBean, CreateReservationDeleteDTOBean createReservationDeleteDTOBean) {
        this.getReservationDTOBean = getReservationDTOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.createReservationDeleteDTOBean = createReservationDeleteDTOBean;
    }

    // 예약 삭제
    public ResponseReservationDeleteUpdateDTO exec(RequestReservationDeleteUpdateDTO requestReservationDeleteUpdateDTO) {
        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDTOBean.exec(requestReservationDeleteUpdateDTO.getReservationId(), requestReservationDeleteUpdateDTO.getBoothId());
        if(reservationDAO == null) return null;

        // 예약 삭제여부 isCancel 값 수정
        if(!reservationDAO.getIsCancel())
            reservationDAO.setIsCancel(true);
        else
            return null;

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);

        // DTO 생성해서 반환
        return createReservationDeleteDTOBean.exec(reservationDAO);
    }
}
