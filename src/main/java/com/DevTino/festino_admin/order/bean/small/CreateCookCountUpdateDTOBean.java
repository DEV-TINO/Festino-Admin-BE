package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCookCountUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseCookCountUpdateDTO exec(CookDTO cookDTO){

        return ResponseCookCountUpdateDTO.builder()
                .cookId(cookDTO.getCookId())
                .servedCount(cookDTO.getServedCount())
                .build();

    }

}
