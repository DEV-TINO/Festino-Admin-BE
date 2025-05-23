package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.message.bean.SaveReservationSendMessageBean;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationRestoreDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationRestoreUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationRestoreUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SaveReservationRestoreBean {
    GetReservationDAOBean getReservationDAOBean;
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateReservationRestoreDTOBean createReservationRestoreDTOBean;
    SaveReservationSendMessageBean saveReservationSendMessageBean;

    @Autowired
    public SaveReservationRestoreBean(GetReservationDAOBean getReservationDAOBean, GetNightBoothDAOBean getNightBoothDAOBean, SaveReservationDAOBean saveReservationDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateReservationRestoreDTOBean createReservationRestoreDTOBean, SaveReservationSendMessageBean saveReservationSendMessageBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createReservationRestoreDTOBean = createReservationRestoreDTOBean;
        this.saveReservationSendMessageBean = saveReservationSendMessageBean;
    }

    // 예약 복구
    // 취소 -> 대기
    // 완료 -> 대기

    public ResponseReservationRestoreUpdateDTO exec(RequestReservationRestoreUpdateDTO requestReservationRestoreUpdateDTO) throws IOException {
        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationRestoreUpdateDTO.getReservationId(), requestReservationRestoreUpdateDTO.getBoothId());

        // 예약된 전화번호인지 확인
        ReservationDAO oldReservationDAO = getReservationDAOBean.exec(reservationDAO.getPhoneNum());
        if (oldReservationDAO != null) throw new ServiceException(ExceptionEnum.RESERVATION_ALREADY_EXIST);

        // boothId를 통해 원하는 부스객체 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestReservationRestoreUpdateDTO.getBoothId());

        // 예약의 상태 타입이 입력값과 다른 경우 예외 발생
        if(!reservationDAO.getReservationType().equals(requestReservationRestoreUpdateDTO.getReservationType())) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // 예약 복구여부 변경
        reservationDAO.setReservationType(ReservationEnum.RESERVE);
        reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 야간부스 총 예약수 +1
        nightBoothDAO.setTotalReservationNum(nightBoothDAO.getTotalReservationNum()+1);
        reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);
        saveNightBoothDAOBean.exec(nightBoothDAO);

        String messageStatus = saveReservationSendMessageBean.exec(requestReservationRestoreUpdateDTO.getBoothId(), reservationDAO.getPhoneNum(), reservationDAO.getUserName());

        // DTO 생성해서 반환
        ResponseReservationRestoreUpdateDTO responseReservationRestoreUpdateDTO = createReservationRestoreDTOBean.exec(reservationDAO);
        responseReservationRestoreUpdateDTO.setMessageStatus(messageStatus);
        return responseReservationRestoreUpdateDTO;
    }
}
