package com.DevTino.festino_admin.menu.domain.DTO;

import com.DevTino.festino_admin.menu.domain.MenuType;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestMenuSaveDTO {
    UUID boothId;
    String menuName;
    Integer menuPrice;
    String menuDescription;
    String menuImage;
    MenuType menuType;
    Boolean isSoldOut;
}
