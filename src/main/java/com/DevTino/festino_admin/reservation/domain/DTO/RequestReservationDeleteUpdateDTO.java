package com.DevTino.festino_admin.reservation.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestReservationDeleteUpdateDTO {
    UUID boothId;
    UUID reservationId;
    Boolean isCancel;
}
