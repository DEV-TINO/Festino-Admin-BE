package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationCompleteDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationCompleteDTOBean {
    public ResponseReservationCompleteDTO exec(ReservationDAO reservationDAO) {
        return ResponseReservationCompleteDTO.builder()
                .reservationId(reservationDAO.getReservationId())
                .reservationType(reservationDAO.getReservationType())
                .build();
    }
}
