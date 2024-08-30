package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.MenuInfoDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCookDAOBean {

    // DAO 생성해 반환
    public CookDTO exec(MenuInfoDTO menu, OrderDTO orderDTO){

        return CookDTO.builder()
                .cookId(UUID.randomUUID())
                .orderId(orderDTO.getOrderId())
                .boothId(orderDTO.getBoothId())
                .tableNum(orderDTO.getTableNum())
                .date(orderDTO.getDate())
                .menuId(menu.getMenuId())
                .totalCount(menu.getMenuCount())
                .servedCount(0)
                .createAt(DateTimeUtils.nowZone())
                .isFinish(false)
                .isService(orderDTO.getIsService())
                .build();

    }

}
