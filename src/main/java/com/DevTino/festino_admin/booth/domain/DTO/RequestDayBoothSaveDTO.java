package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RequestDayBoothSaveDTO {
    String boothName;
    String adminName;
    String adminCategory;
    String openTime;
    String closeTime;
    String boothIntro;
    List<String> boothImage;
    Boolean isOpen;
}
