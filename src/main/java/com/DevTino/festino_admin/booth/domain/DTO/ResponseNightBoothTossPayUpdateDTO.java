package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseNightBoothTossPayUpdateDTO {
    UUID boothId;
    Boolean isTossPay;
}
