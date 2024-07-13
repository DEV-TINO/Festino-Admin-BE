package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.reservation.domain.DTO.ResponseReservationDeleteUpdateDTO;
import com.DevTino.festino_admin.reservation.domain.ReservationDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationDeleteDTOBean {
    public ResponseReservationDeleteUpdateDTO exec(ReservationDAO reservationDAO) {
        return ResponseReservationDeleteUpdateDTO.builder()
                .reservationId(reservationDAO.getReservationId())
                .isCancel(reservationDAO.getIsCancel())
                .build();
    }
}
