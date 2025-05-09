package com.DevTino.festino_admin.booth.domain;

import com.DevTino.festino_admin.booth.others.StringMapConverter;
import com.DevTino.festino_admin.booth.others.StringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
    String tossPay;
    String kakaoPay;

    @Convert(converter = StringConverter.class)
    List<String> boothImage;
    String openTime;
    String closeTime;
    Boolean isOpen;
    Boolean isOrder;
    Boolean isReservation;
    Boolean isTossPay;
    Boolean isKakaoPay;
    Boolean isCall;

    Integer markerNum;
    String location;

    LocalDateTime createAt;
    LocalDateTime updateAt;
    Integer totalReservationNum;

    @Convert(converter = StringMapConverter.class)
    Map<String, String> accountInfo;
}
