package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

@Data
public class RequestDayBoothSaveDTO {
    String boothName;
    String adminName;
    String adminCategory;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    Boolean isOpen;
}
