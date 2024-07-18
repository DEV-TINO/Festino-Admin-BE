package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCookFinishUpdateDTOBean {

    // DTO 생성해 반환
    public ResponseCookFinishUpdateDTO exec(CookDAO cookDAO){

        return ResponseCookFinishUpdateDTO.builder()
                .cookId(cookDAO.getCookId())
                .isFinish(cookDAO.getIsFinish())
                .build();

    }

}
