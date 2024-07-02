package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestNightBoothUpdateDTO {
    UUID boothId;
    String boothName;
    String adminName;
    String adminCategory;
    String boothIntro;
    String boothImage;
    String openTime;
    String closeTime;
    String location;
    Boolean isOrder;
    Boolean isOpen;
    Boolean isReservation;
}
