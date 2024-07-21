package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.List;
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
    Boolean isOrder;
    Boolean isOpen;
    Boolean isReservation;
}
