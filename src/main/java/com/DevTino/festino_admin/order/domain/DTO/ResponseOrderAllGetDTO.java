package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ResponseOrderAllGetDTO {

    UUID orderId;
    String orderType;
    Integer orderNum;
    Integer tableNum;
    String userName;
    String phoneNum;
    Integer totalPrice;
    List<Map<String, Object>> menuList;

}
