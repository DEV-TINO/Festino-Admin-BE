package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestNightBoothOrderUpdateDTO {
    UUID boothId;
    Boolean isOrder;
}
