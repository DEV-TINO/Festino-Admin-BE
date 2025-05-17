package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseAllTableOrderGetDTO {
    private Integer tableNumIndex;
    private String type;
    private OrderDTO orderInfo;
}
