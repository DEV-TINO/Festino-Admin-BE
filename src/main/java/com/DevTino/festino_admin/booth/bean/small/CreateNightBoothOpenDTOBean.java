package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOpenGetGTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothOpenDTOBean {

    // 야간부스 운영 중 DTO 생성
    public ResponseNightBoothOpenGetGTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothOpenGetGTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isOpen(nightBoothDAO.getIsOpen())
                .build();
    }
}
