package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.message.bean.CompleteReservationSendMessageBean;
import com.DevTino.festino_admin.message.bean.ReservationTop2SendMessageBean;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationCompleteDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationsDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationCompleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationCompleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DeleteReservationCompleteBean {
    GetReservationDAOBean getReservationDAOBean;
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateReservationCompleteDTOBean createReservationCompleteDTOBean;
    CompleteReservationSendMessageBean completeReservationSendMessageBean;
    ReservationTop2SendMessageBean reservationTop2SendMessageBean;
    GetReservationsDAOBean getReservationsDAOBean;

    @Autowired
    public DeleteReservationCompleteBean(GetReservationDAOBean getReservationDAOBean, GetNightBoothDAOBean getNightBoothDAOBean, SaveReservationDAOBean saveReservationDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateReservationCompleteDTOBean createReservationCompleteDTOBean, CompleteReservationSendMessageBean completeReservationSendMessageBean, ReservationTop2SendMessageBean reservationTop2SendMessageBean, GetReservationsDAOBean getReservationsDAOBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createReservationCompleteDTOBean = createReservationCompleteDTOBean;
        this.completeReservationSendMessageBean = completeReservationSendMessageBean;
        this.reservationTop2SendMessageBean = reservationTop2SendMessageBean;
        this.getReservationsDAOBean = getReservationsDAOBean;
    }

    // 예약 입장
    // 대기 -> 입장
    // 취소 -> 입장
    public ResponseReservationCompleteUpdateDTO exec(RequestReservationCompleteUpdateDTO requestReservationCompleteUpdateDTO) throws IOException {

        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationCompleteUpdateDTO.getReservationId(), requestReservationCompleteUpdateDTO.getBoothId());

        // 예약 대기인 경우 총 에약수 감소
        if (reservationDAO.getReservationType().equals(ReservationEnum.RESERVE)) {

            // boothId를 통해 원하는 부스객체 찾기
            NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestReservationCompleteUpdateDTO.getBoothId());

            // 야간부스 총 예약수 -1
            nightBoothDAO.setTotalReservationNum(nightBoothDAO.getTotalReservationNum()-1);
            reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

            // 예약 완료여부 isCancel 값 수정
            reservationDAO.setReservationType(ReservationEnum.COMPLETE);
            reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

            // 수정된 DAO 값 저장
            saveReservationDAOBean.exec(reservationDAO);
            saveNightBoothDAOBean.exec(nightBoothDAO);

            /*// 대기 1팀 메세지 전송
            List<ReservationDAO> reservationDAOList = getReservationsDAOBean.exec(reservationDAO.getBoothId());
            if (reservationDAOList != null) {
                ReservationDAO top2ReservationDAO = reservationDAOList.size() > 1 ? reservationDAOList.get(1) : null;
                if (top2ReservationDAO != null) {
                    String top2MessageStatus = reservationTop2SendMessageBean.exec(top2ReservationDAO.getPhoneNum(), top2ReservationDAO.getUserName());
                }
            }*/

            // 완료 메세지 전송
            String deleteMessageStatus = completeReservationSendMessageBean.exec(requestReservationCompleteUpdateDTO.getBoothId(), reservationDAO.getPhoneNum(), reservationDAO.getUserName());

            // DTO 생성
            ResponseReservationCompleteUpdateDTO responseReservationCompleteUpdateDTO = createReservationCompleteDTOBean.exec(reservationDAO);
            responseReservationCompleteUpdateDTO.setMessageStatus(deleteMessageStatus);
            return responseReservationCompleteUpdateDTO;
        }

        // 예약 완료여부 isCancel 값 수정
        reservationDAO.setReservationType(ReservationEnum.COMPLETE);

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);
        reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 완료 메세지 전송
        String deleteMessageStatus = completeReservationSendMessageBean.exec(requestReservationCompleteUpdateDTO.getBoothId(), reservationDAO.getPhoneNum(), reservationDAO.getUserName());

        // DTO 생성
        ResponseReservationCompleteUpdateDTO responseReservationCompleteUpdateDTO = createReservationCompleteDTOBean.exec(reservationDAO);
        responseReservationCompleteUpdateDTO.setMessageStatus(deleteMessageStatus);
        return responseReservationCompleteUpdateDTO;
    }
}
