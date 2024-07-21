package com.DevTino.festino_admin.reservation.domain.DTO;

import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestReservationCompleteDTO {
    UUID boothId;
    UUID reservationId;
    ReservationEnum reservationType;
}
