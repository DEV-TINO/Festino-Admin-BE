package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestNightBoothUpdateDTO {
    UUID boothId;
    String boothName;
    String adminName;
    String boothIntro;
    String boothImage;
    String openTime;
    String closeTime;
    String location;
    String description;
    String descriptImage;
    Boolean isOrder;
    Boolean isOpen;
}
