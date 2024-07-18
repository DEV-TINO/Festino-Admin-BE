package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderTableGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderTableGetDTO exec(OrderDAO orderDAO, List<CookDAO> cookDAOList){

        Integer servedCount = 0;
        Integer totalCount = 0;

        // 모든 cookDAO의 servedCount, totalCount 총합 구하기
        for (CookDAO cookDAO : cookDAOList){

            servedCount += cookDAO.getServedCount();
            totalCount += cookDAO.getTotalCount();

        }

        // DTO 생성해 반환
        return ResponseOrderTableGetDTO.builder()
                .orderId(orderDAO.getOrderId())
                .orderType(orderDAO.getOrderType().name())
                .tableNum(orderDAO.getTableNum())
                .servedCount(servedCount)
                .totalCount(totalCount)
                .build();

    }

}
