package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothOpenDTOBean {

    // 야간부스 운영 중 DTO 생성
    public ResponseNightBoothOpenUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothOpenUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isOpen(nightBoothDAO.getIsOpen())
                .build();
    }
}
