package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseOrderFinishRestoreUpdateDTO {

    UUID orderId;
    String orderType;

}
