package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.reservation.bean.small.CreateReservationDeleteDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationDeleteDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReservationBean {
    GetReservationDAOBean getReservationDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    CreateReservationDeleteDTOBean createReservationDeleteDTOBean;

    @Autowired
    public DeleteReservationBean(GetReservationDAOBean getReservationDAOBean, SaveReservationDAOBean saveReservationDAOBean, CreateReservationDeleteDTOBean createReservationDeleteDTOBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.createReservationDeleteDTOBean = createReservationDeleteDTOBean;
    }

    // 예약 삭제
    public ResponseReservationDeleteDTO exec(RequestReservationDeleteDTO requestReservationDeleteDTO) {
        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationDeleteDTO.getReservationId(), requestReservationDeleteDTO.getBoothId());
        if(reservationDAO == null) return null;

        // 예약 삭제여부 isCancel 값 수정
        if(!reservationDAO.getIsCancel() && !requestReservationDeleteDTO.getIsCancel())
            reservationDAO.setIsCancel(true);
        else
            return null;

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);

        // DTO 생성해서 반환
        return createReservationDeleteDTOBean.exec(reservationDAO);
    }
}
