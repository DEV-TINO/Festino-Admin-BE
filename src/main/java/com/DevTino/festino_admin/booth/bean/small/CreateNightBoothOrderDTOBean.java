package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOrderUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothOrderDTOBean {

    // 야간부스 주문 가능 여부 DTO 생성
    public ResponseNightBoothOrderUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothOrderUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isOrder(nightBoothDAO.getIsOrder())
                .build();
    }
}
