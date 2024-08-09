package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTableNumGetDTO {
    Integer tableNumIndex;
    String customTableNum;
    String orderUrl;
}
