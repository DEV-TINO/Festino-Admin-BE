package com.DevTino.festino_admin.booth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NightBoothDAO {
    @Id
    UUID boothId;

    String boothName;
    String adminName;
    String adminCategory;
    String boothIntro;
    String boothImage;
    String openTime;
    String closeTime;
    String location;
    Boolean isOpen;
    Boolean isOrder;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    Integer totalReservationNum;
}
