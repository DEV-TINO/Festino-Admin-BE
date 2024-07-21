package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ResponseOrderStatisticGetDTO {

    Integer totalSale;
    List<Map<String, Object>> menuSaleList;

}
