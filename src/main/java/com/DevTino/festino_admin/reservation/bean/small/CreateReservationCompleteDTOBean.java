package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationCompleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationCompleteDTOBean {
    public ResponseReservationCompleteUpdateDTO exec(ReservationDAO reservationDAO) {
        return ResponseReservationCompleteUpdateDTO.builder()
                .reservationId(reservationDAO.getReservationId())
                .reservationType(reservationDAO.getReservationType())
                .build();
    }
}
