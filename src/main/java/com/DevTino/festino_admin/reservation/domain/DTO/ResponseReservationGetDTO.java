package com.DevTino.festino_admin.reservation.domain.DTO;

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
    Boolean isDeleted;
}
