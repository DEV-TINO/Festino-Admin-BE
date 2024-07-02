package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

@Data
public class RequestNightBoothSaveDTO {
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
    Boolean isReservation;
}
