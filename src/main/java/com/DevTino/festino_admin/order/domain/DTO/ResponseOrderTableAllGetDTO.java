package com.DevTino.festino_admin.order.domain.DTO;

import com.DevTino.festino_admin.order.domain.OrderType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseOrderTableAllGetDTO {

    UUID orderId;
    String orderType;
    Integer orderNum;
    Integer tableNum;
    String userName;
    String phoneNum;
    Integer totalPrice;
    Boolean isDeposit;
    List<MenuInfoDTO> menuList;
    LocalDateTime createAt;
    LocalDateTime finishAt;
}
