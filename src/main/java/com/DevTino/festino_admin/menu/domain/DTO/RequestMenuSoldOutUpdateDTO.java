package com.DevTino.festino_admin.menu.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestMenuSoldOutUpdateDTO {
    UUID menuId;
    UUID boothId;
    Boolean isSoldOut;
}
