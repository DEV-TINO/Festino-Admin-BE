package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationDeleteDTOBean {
    public ResponseReservationDeleteDTO exec(ReservationDAO reservationDAO) {
        return ResponseReservationDeleteDTO.builder()
                .reservationId(reservationDAO.getReservationId())
                .reservationType(reservationDAO.getReservationType())
                .build();
    }
}
