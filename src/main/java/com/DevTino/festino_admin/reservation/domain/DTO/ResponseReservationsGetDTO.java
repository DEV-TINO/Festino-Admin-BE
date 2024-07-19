package com.DevTino.festino_admin.reservation.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseReservationsGetDTO {
    List<ResponseReservationGetDTO> ReservationList;
    Integer totalReservationNum;
    Boolean isReservation;
}
