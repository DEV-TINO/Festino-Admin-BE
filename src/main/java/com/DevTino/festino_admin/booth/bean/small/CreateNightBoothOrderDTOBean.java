package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOrderGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothOrderDTOBean {

    // 야간부스 예약가능 여부 DTO 생성
    public ResponseNightBoothOrderGetDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothOrderGetDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isOrder(nightBoothDAO.getIsOrder())
                .build();
    }
}
