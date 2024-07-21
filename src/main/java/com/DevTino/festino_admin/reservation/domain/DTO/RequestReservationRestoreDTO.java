package com.DevTino.festino_admin.reservation.domain.DTO;

import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestReservationRestoreDTO {
    UUID boothId;
    UUID reservationId;
    ReservationEnum reservationType;
}
