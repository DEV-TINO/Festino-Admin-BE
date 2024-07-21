package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RequestFoodBoothUpdateDTO {
    UUID boothId;
    String adminName;
    String adminCategory;
    String boothName;
    String openTime;
    String closeTime;
    String boothIntro;
    List<String> boothImage;
    Boolean isOpen;
}
