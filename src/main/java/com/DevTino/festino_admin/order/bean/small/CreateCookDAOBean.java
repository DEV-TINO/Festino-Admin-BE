package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class CreateCookDAOBean {

    // DAO 생성해 반환
    public CookDAO exec(Map<String, Object> menu, OrderDAO orderDAO){

        return CookDAO.builder()
                .cookId(UUID.randomUUID())
                .orderId(orderDAO.getOrderId())
                .boothId(orderDAO.getBoothId())
                .tableNum(orderDAO.getTableNum())
                .date(orderDAO.getDate())
                .menuId((UUID) menu.get("menuId"))
                .totalCount((Integer) menu.get("menuCount"))
                .servedCount(0)
                .createAt(DateTimeUtils.nowZone())
                .isFinish(false)
                .build();

    }

}
