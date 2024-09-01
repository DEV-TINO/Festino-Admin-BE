package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseOrderDetailGetDTO {

    UUID orderId;
    Integer orderNum;
    Integer tableNum;
    String userName;
    String phoneNum;
    String note;
    Integer totalPrice;
    List<MenuInfoDTO> menuList;
    LocalDateTime createAt;
    LocalDateTime finishAt;

}
