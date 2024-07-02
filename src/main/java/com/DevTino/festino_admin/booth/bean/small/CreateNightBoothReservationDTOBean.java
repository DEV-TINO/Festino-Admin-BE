package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothReservationGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothReservationDTOBean {

    // 야간부스 예약 가능 여부 DTO 생성
    public ResponseNightBoothReservationGetDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothReservationGetDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isReservation(nightBoothDAO.getIsReservation())
                .build();
    }
}
