package com.DevTino.festino_admin.reservation.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class ResponseReservationUpdateDTO {
    UUID boothId;
    Boolean isReservation;
}
