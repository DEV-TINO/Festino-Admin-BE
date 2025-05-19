package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class RequestNightBoothUpdateDTO {
    UUID boothId;
    String boothName;
    String adminName;
    String adminCategory;
    String boothIntro;
    List<String> boothImage;
    String openTime;
    String closeTime;
    String tossPay;
    String kakaoPay;
    Boolean isOrder;
    Boolean isOpen;
    Boolean isReservation;
    Boolean isTossPay;
    Boolean isKakaoPay;
    Boolean isCall;
    Map<String, String> accountInfo;
}
