package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderServiceSaveDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateOrderDAOBean {

    // requestOrderSaveDTO 정보로 OrderDAO 생성해 반환
    public OrderDTO exec(Integer date, UUID boothId, RequestOrderServiceSaveDTO requestOrderServiceSaveDTO) {

        return OrderDTO.builder()
                .orderId(UUID.randomUUID())
                .boothId(boothId)
                .tableNum(requestOrderServiceSaveDTO.getTableNum())
                .userName("service")
                .phoneNum("00000000000")
                .date(date)
                .orderType(OrderType.COOKING)
                .menuInfo(requestOrderServiceSaveDTO.getMenuInfo())
                .totalPrice(requestOrderServiceSaveDTO.getTotalPrice())
                .createAt(DateTimeUtils.nowZone())
                .isCoupon(requestOrderServiceSaveDTO.getIsCoupon())
                .isDeposit(true)
                .isService(requestOrderServiceSaveDTO.getIsService())
                .build();

    }

}
