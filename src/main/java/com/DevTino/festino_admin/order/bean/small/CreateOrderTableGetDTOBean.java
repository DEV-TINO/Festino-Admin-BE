package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableGetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderTableGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderTableGetDTO exec(OrderDTO orderDTO, List<CookDTO> cookDTOList){

        Integer servedCount = 0;
        Integer totalCount = 0;

        // 모든 cookDAO의 servedCount, totalCount 총합 구하기
        for (CookDTO cookDTO : cookDTOList){

            servedCount += cookDTO.getServedCount();
            totalCount += cookDTO.getTotalCount();

        }

        // DTO 생성해 반환
        return ResponseOrderTableGetDTO.builder()
                .orderId(orderDTO.getOrderId())
                .orderType(orderDTO.getOrderType().name())
                .tableNum(orderDTO.getTableNum())
                .servedCount(servedCount)
                .totalCount(totalCount)
                .createAt(orderDTO.getCreateAt())
                .build();

    }

}
