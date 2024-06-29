package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

@Data
public class RequestNightBoothSaveDTO {
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
}
