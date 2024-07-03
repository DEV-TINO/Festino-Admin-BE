package com.DevTino.festino_admin.menu.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestMenuSaveDTO {
    UUID menuId;
    UUID boothId;
    String menuName;
    Integer menuPrice;
    String menuDescription;
    String menuImage;
    Boolean isSoldOut;
}
