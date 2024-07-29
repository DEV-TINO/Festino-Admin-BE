package com.DevTino.festino_admin.reservation.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.message.bean.DeleteReservationSendMessageBean;
import com.DevTino.festino_admin.message.bean.ReservationTop2SendMessageBean;
import com.DevTino.festino_admin.reservation.bean.small.CreateReservationDeleteDTOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.GetReservationsDAOBean;
import com.DevTino.festino_admin.reservation.bean.small.SaveReservationDAOBean;
import com.DevTino.festino_admin.reservation.domain.DTO.RequestReservationDeleteDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DeleteReservationCancelBean {
    GetReservationDAOBean getReservationDAOBean;
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveReservationDAOBean saveReservationDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateReservationDeleteDTOBean createReservationDeleteDTOBean;
    DeleteReservationSendMessageBean deleteReservationSendMessageBean;
    ReservationTop2SendMessageBean reservationTop2SendMessageBean;
    GetReservationsDAOBean getReservationsDAOBean;

    @Autowired
    public DeleteReservationCancelBean(GetReservationDAOBean getReservationDAOBean, GetNightBoothDAOBean getNightBoothDAOBean, SaveReservationDAOBean saveReservationDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateReservationDeleteDTOBean createReservationDeleteDTOBean, DeleteReservationSendMessageBean deleteReservationSendMessageBean, ReservationTop2SendMessageBean reservationTop2SendMessageBean, GetReservationsDAOBean getReservationsDAOBean) {
        this.getReservationDAOBean = getReservationDAOBean;
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveReservationDAOBean = saveReservationDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createReservationDeleteDTOBean = createReservationDeleteDTOBean;
        this.deleteReservationSendMessageBean = deleteReservationSendMessageBean;
        this.reservationTop2SendMessageBean = reservationTop2SendMessageBean;
        this.getReservationsDAOBean = getReservationsDAOBean;
    }

    // 예약 취소
    // 완료 -> 취소
    // 대기 -> 취소
    public ResponseReservationDeleteDTO exec(RequestReservationDeleteDTO requestReservationDeleteDTO) throws IOException {

        // reservationId와 boothId를 통해 원하는 객체(DAO) 찾기
        ReservationDAO reservationDAO = getReservationDAOBean.exec(requestReservationDeleteDTO.getReservationId(), requestReservationDeleteDTO.getBoothId());
        if(reservationDAO == null) return null;

        // boothId를 통해 원하는 부스객체 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestReservationDeleteDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // 예약 대기인 경우 총 에약수 감소
        if (reservationDAO.getReservationType() == ReservationEnum.RESERVE){
            // 야간부스 총 예약수 -1
            nightBoothDAO.setTotalReservationNum(nightBoothDAO.getTotalReservationNum()-1);
            nightBoothDAO.setUpdateAt(DateTimeUtils.nowZone());

            // 예약 삭제여부 isCancel 값 수정
            reservationDAO.setReservationType(ReservationEnum.CANCEL);
            reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

            // 수정된 DAO 값 저장
            saveNightBoothDAOBean.exec(nightBoothDAO);
            saveReservationDAOBean.exec(reservationDAO);

            // 대기 1팀 메세지 전송
            List<ReservationDAO> reservationDAOList = getReservationsDAOBean.exec(reservationDAO.getBoothId());
            if (reservationDAOList != null) {
                ReservationDAO top2ReservationDAO = reservationDAOList.size() > 1 ? reservationDAOList.get(1) : null;
                if (top2ReservationDAO != null) {
                    String top2MessageStatus = reservationTop2SendMessageBean.exec(top2ReservationDAO.getPhoneNum(), top2ReservationDAO.getUserName());
                }
            }

            // 삭제 메세지 전송
            String deleteMessageStatus = deleteReservationSendMessageBean.exec(reservationDAO.getPhoneNum(), reservationDAO.getUserName(), nightBoothDAO.getAdminName());

            // DTO 생성
            ResponseReservationDeleteDTO responseReservationDeleteDTO = createReservationDeleteDTOBean.exec(reservationDAO);
            responseReservationDeleteDTO.setMessageStatus(deleteMessageStatus);
            return responseReservationDeleteDTO;
        }

        // 예약 삭제여부 isCancel 값 수정
        reservationDAO.setReservationType(ReservationEnum.CANCEL);
        reservationDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정된 DAO 값 저장
        saveReservationDAOBean.exec(reservationDAO);

        // 삭제 메세지 전송
        String deleteMessageStatus = deleteReservationSendMessageBean.exec(reservationDAO.getPhoneNum(), reservationDAO.getUserName(), nightBoothDAO.getAdminName());

        // DTO 생성
        ResponseReservationDeleteDTO responseReservationDeleteDTO = createReservationDeleteDTOBean.exec(reservationDAO);
        responseReservationDeleteDTO.setMessageStatus(deleteMessageStatus);
        return responseReservationDeleteDTO;
    }
}
