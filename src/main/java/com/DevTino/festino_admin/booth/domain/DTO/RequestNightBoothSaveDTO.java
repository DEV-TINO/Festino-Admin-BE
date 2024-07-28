package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestNightBoothSaveDTO {
    String boothName;
    String adminName;
    String adminCategory;
    String boothIntro;
    List<String> boothImage;
    String openTime;
    String closeTime;
    Boolean isOpen;
    Boolean isOrder;
    Boolean isReservation;
    Map<String, String> accountInfo;
}
