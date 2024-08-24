package com.DevTino.festino_admin.order.domain.DTO;

import com.DevTino.festino_admin.order.domain.OrderType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {
    Integer orderNum;
    UUID orderId;
    UUID boothId;
    OrderType orderType;
    Integer tableNum;
    Integer date;
    String userName;
    String phoneNum;
    Integer totalPrice;
    Boolean isDeposit;
    Boolean isCoupon;
    LocalDateTime createAt;
    List<MenuInfoDTO> menuInfo;
}
