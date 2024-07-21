package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RequestFoodBoothSaveDTO {
    String adminName;
    String adminCategory;
    String boothName;
    String openTime;
    String closeTime;
    String boothIntro;
    List<String> boothImage;
    Boolean isOpen;
}
