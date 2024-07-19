package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationGetDTO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationsGetDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CreateReservationsDTOBean {
    GetNightBoothDAOBean getNightBoothDAOBean;

    @Autowired
    public CreateReservationsDTOBean(GetNightBoothDAOBean getNightBoothDAOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
    }

    // 예약 DTO 리스트 생성해서 반환
    public ResponseReservationsGetDTO exec(List<ReservationDAO> reservationDAOList, UUID boothId) {
        // DTO 리스트 생성
        List<ResponseReservationGetDTO> responseReservationGetDTOList = new ArrayList<>();

        // for문을 이용해서 객체(DAO)를 하나씩 꺼내 DTO 삽입
        for(ReservationDAO reservationDAO : reservationDAOList) {

            // 예약 DTO 생성
            ResponseReservationGetDTO responseReservationGetDTO = ResponseReservationGetDTO.builder()
                    .reservationId(reservationDAO.getReservationId())
                    .userName(reservationDAO.getUserName())
                    .personCount(reservationDAO.getPersonCount())
                    .phoneNum(reservationDAO.getPhoneNum())
                    .updateAt(reservationDAO.getUpdateAt())
                    .isCancel(reservationDAO.getIsCancel())
                    .reservationNum(reservationDAO.getReservationNum())
                    .build();

            // 예약 DTO 리스트에 각 DTO 추가
            responseReservationGetDTOList.add(responseReservationGetDTO);
        }

        // 예약 리스트, 예약가능 여부, 총 예약수를 묶은 DTO 생성 후 반환
        return ResponseReservationsGetDTO.builder()
                // 예약 리스트
                .ReservationList(responseReservationGetDTOList)

                // 예약가능 여부(boothId를 통해 원하는 야간부스 객체를 찾고 그 객체의 예약여부 가져오기)
                .isReservation(getNightBoothDAOBean.exec(boothId).getIsReservation())

                // 총 예약수
                .totalNum(reservationDAOList.size())
                .build();
    }
}
