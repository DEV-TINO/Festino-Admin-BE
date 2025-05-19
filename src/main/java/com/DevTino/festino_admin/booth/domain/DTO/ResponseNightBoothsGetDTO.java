package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseNightBoothsGetDTO {
    UUID boothId;
    String adminCategory;
    String adminName;
    String boothName;
    String openTime;
    String closeTime;
    Boolean isOpen;
    Boolean isOrder;
    Boolean isCall;
    Integer markerNum;
    String location;
    Boolean isReservation;
}
