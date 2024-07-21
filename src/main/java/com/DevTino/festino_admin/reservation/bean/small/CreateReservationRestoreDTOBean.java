package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationRestoreUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationRestoreDTOBean {

    // 예약 복구 DTO 생성하고 반환
    public ResponseReservationRestoreUpdateDTO exec(ReservationDAO reservationDAO) {
        return ResponseReservationRestoreUpdateDTO.builder()
                .reservationId(reservationDAO.getReservationId())
                .reservationType(reservationDAO.getReservationType())
                .build();
    }
}
