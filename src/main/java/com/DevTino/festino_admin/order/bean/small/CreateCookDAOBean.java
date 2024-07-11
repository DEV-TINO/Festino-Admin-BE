package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Component
public class CreateCookDAOBean {

    public CookDAO exec(Map<String, Object> menu, UUID orderId){

        return CookDAO.builder()
                .cookId(UUID.randomUUID())
                .orderId(orderId)
                .menuName((String) menu.get("menuName"))
                .totalCount((Integer) menu.get("menuCount"))
                .servedCount(0)
                .createAt(LocalDateTime.now())
                .isEnd(false)
                .build();

    }

}
