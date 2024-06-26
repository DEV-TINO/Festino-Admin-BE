package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseFoodBoothGetDTO {
    UUID boothId;
    String boothName;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    String descriptImage;
    Boolean isOpen;
}
