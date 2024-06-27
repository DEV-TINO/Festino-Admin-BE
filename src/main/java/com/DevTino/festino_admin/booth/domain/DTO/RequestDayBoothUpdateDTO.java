package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestDayBoothUpdateDTO {
    UUID boothId;
    String boothName;
    String adminName;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    String description;
    String descriptImage;
    Boolean isOpen;
}
