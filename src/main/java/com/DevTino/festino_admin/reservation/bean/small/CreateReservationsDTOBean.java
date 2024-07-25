package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationGetDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateReservationsDTOBean {

    // 예약 DTO 리스트 생성해서 반환
    public ResponseReservationsGetDTO exec(String type, NightBoothDAO nightBoothDAO, List<ReservationDAO> reservationDAOList) {
        // DTO 리스트 생성
        List<ResponseReservationGetDTO> responseReservationGetDTOList = new ArrayList<>();

        // 예약 번호
        int reservationNum = 0;

        // type 매핑
        ReservationEnum reservationEnum;
        switch (type) {
            case "cancel" -> reservationEnum = ReservationEnum.CANCEL;
            case "reserve" -> reservationEnum = ReservationEnum.RESERVE;
            case "complete" -> reservationEnum = ReservationEnum.COMPLETE;
            default -> {
                return null;
            }
        }

        // for문을 이용해서 객체(DAO)를 하나씩 꺼내 DTO 삽입
        for(ReservationDAO reservationDAO : reservationDAOList) {

            reservationNum++;

            if (reservationDAO.getReservationType().equals(reservationEnum)) {
                // 예약 DTO 생성
                ResponseReservationGetDTO responseReservationGetDTO = ResponseReservationGetDTO.builder()
                        .reservationId(reservationDAO.getReservationId())
                        .userName(reservationDAO.getUserName())
                        .personCount(reservationDAO.getPersonCount())
                        .phoneNum(reservationDAO.getPhoneNum())
                        .updateAt(reservationDAO.getUpdateAt())
                        .reservationNum(reservationNum)
                        .build();

                // 예약 DTO 리스트에 각 DTO 추가
                responseReservationGetDTOList.add(responseReservationGetDTO);
            }
        }

        // 예약 리스트, 예약가능 여부, 총 예약수를 묶은 DTO 생성 후 반환
        return ResponseReservationsGetDTO.builder()
                // 예약 리스트
                .ReservationList(responseReservationGetDTOList)

                // 예약가능 여부(boothId를 통해 원하는 야간부스 객체를 찾고 그 객체의 예약여부 가져오기)
                .isReservation(nightBoothDAO.getIsReservation())

                // 총 예약수
                .totalNum(responseReservationGetDTOList.size())
                .build();
    }
}
