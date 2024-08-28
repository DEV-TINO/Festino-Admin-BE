package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCookFinishUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseCookFinishUpdateDTO exec(CookDTO cookDTO){

        return ResponseCookFinishUpdateDTO.builder()
                .cookId(cookDTO.getCookId())
                .isFinish(cookDTO.getIsFinish())
                .build();

    }

}
