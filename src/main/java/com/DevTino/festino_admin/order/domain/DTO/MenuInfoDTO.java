package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuInfoDTO {

    UUID menuId;
    String menuName;
    Integer menuCount;
    Integer menuPrice;

}
