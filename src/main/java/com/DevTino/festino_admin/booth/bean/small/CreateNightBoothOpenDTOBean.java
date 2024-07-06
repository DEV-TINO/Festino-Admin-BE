package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOpenGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothOpenDTOBean {

    // 야간부스 운영 중 DTO 생성
    public ResponseNightBoothOpenGetDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothOpenGetDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isOpen(nightBoothDAO.getIsOpen())
                .build();
    }
}
