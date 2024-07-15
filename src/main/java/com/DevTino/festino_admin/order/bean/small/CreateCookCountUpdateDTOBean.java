package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCookCountUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseCookCountUpdateDTO exec(CookDAO cookDAO){

        return ResponseCookCountUpdateDTO.builder()
                .cookId(cookDAO.getCookId())
                .servedCount(cookDAO.getServedCount())
                .build();

    }

}
