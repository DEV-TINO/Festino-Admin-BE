package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothReservationUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothReservationDTOBean {

    // 야간부스 예약 가능 여부 DTO 생성
    public ResponseNightBoothReservationUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothReservationUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isReservation(nightBoothDAO.getIsReservation())
                .build();
    }
}
