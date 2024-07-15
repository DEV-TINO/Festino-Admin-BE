package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationRestoreDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationRestoreDTOBean {

    // 예약 복구 DTO 생성하고 반환
    public ResponseReservationRestoreDTO exec(ReservationDAO reservationDAO) {
        return ResponseReservationRestoreDTO.builder()
                .reservationId(reservationDAO.getReservationId())
                .isCancel(reservationDAO.getIsCancel())
                .build();
    }
}
