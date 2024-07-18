package com.DevTino.festino_admin.menu.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseMenuSoldOutUpdateDTO {
    UUID menuId;
    Boolean isSoldOut;
}
