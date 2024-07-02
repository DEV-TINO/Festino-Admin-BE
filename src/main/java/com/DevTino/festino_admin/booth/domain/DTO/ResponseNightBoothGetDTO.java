package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseNightBoothGetDTO {
    UUID boothId;
    String boothName;
    String adminName;
    String adminCategory;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    Boolean isOpen;
    Boolean isOrder;
    Integer totalReservationNum;
}
