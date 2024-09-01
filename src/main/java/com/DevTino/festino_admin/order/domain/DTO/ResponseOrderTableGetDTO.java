package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseOrderTableGetDTO {

    UUID orderId;
    String orderType;
    Integer tableNum;
    Integer servedCount;
    Integer totalCount;
    LocalDateTime createAt;

}
