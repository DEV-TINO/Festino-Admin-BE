package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationDTOBean {

    // 예약 가능여부 수정
    public ResponseReservationUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseReservationUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isReservation(nightBoothDAO.getIsReservation())
                .build();
    }
}
