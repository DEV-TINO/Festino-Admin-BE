package com.DevTino.festino_admin.reservation.domain.DTO;

import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseReservationCompleteDTO {
    UUID reservationId;
    ReservationEnum reservationType;
}
