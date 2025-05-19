package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ResponseNightBoothGetDTO {
    UUID boothId;
    String boothName;
    String adminName;
    String adminCategory;
    String openTime;
    String closeTime;
    String boothIntro;
    String tossPay;
    String kakaoPay;
    List<String> boothImage;
    Integer markerNum;
    String location;
    Boolean isOpen;
    Boolean isOrder;
    Boolean isReservation;
    Boolean isTossPay;
    Boolean isKakaoPay;
    Boolean isCall;
    Integer totalReservationNum;
    Map<String, String> accountInfo;
}
