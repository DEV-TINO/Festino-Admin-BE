package com.DevTino.festino_admin.reservation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDAO {
    @Id
    UUID reservationId;

    UUID boothId;
    String userName;
    Integer personCount;
    String phoneNum;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    Boolean isCancel;
    Integer reservationNum;
    Integer date;
}
