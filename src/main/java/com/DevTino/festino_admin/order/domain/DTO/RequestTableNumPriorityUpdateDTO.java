package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Data;

@Data
public class RequestTableNumPriorityUpdateDTO {
    private Integer tableNumIndex;
    private Integer tablePriority;
}
