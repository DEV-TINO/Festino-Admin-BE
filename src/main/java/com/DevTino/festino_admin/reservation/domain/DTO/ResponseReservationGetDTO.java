package com.DevTino.festino_admin.reservation.domain.DTO;

import com.DevTino.festino_admin.reservation.domain.ReservationEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseReservationGetDTO {
    UUID reservationId;
    String userName;
    Integer personCount;
    String phoneNum;
    LocalDateTime updateAt;
    Integer reservationNum;
    ReservationEnum reservationType;
}
