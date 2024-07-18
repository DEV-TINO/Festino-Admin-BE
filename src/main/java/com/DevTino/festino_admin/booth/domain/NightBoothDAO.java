package com.DevTino.festino_admin.booth.domain;

import com.DevTino.festino_admin.booth.others.StringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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

    @Convert(converter = StringConverter.class)
    List<String> boothImage;
    String openTime;
    String closeTime;
    String location;
    Boolean isOpen;
    Boolean isOrder;
    Boolean isReservation;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    Integer totalReservationNum;
}
