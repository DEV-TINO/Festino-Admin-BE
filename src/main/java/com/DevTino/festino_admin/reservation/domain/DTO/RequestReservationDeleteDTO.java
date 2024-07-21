package com.DevTino.festino_admin.reservation.domain.DTO;

import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestReservationDeleteDTO {
    UUID boothId;
    UUID reservationId;
}
