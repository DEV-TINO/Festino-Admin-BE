package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

@Data
public class RequestFoodBoothSaveDTO {
    String boothName;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    String descriptImage;
}
