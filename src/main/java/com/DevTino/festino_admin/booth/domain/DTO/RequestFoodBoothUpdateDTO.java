package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestFoodBoothUpdateDTO {
    UUID boothId;
    String boothName;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    String descriptImage;
}