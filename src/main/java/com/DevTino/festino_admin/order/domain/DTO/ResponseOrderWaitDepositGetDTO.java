package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseOrderWaitDepositGetDTO {

    UUID orderId;
    Integer orderNum;
    Integer tableNum;
    String userName;
    String phoneNum;
    Integer totalPrice;
    List<MenuInfoDTO> menuList;
    LocalDateTime createAt;

}
