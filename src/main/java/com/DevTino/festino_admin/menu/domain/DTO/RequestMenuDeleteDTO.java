package com.DevTino.festino_admin.menu.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestMenuDeleteDTO {
    UUID menuId;
    UUID boothId;
}
