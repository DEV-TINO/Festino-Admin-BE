package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookEndUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCookEndUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseCookEndUpdateDTO exec(CookDAO cookDAO){

        return ResponseCookEndUpdateDTO.builder()
                .cookId(cookDAO.getCookId())
                .isEnd(cookDAO.getIsEnd())
                .build();

    }

}
