package com.DevTino.festino_admin.reservation.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestReservationUpdateDTO {
    UUID boothId;
    Boolean isReservation;
}
