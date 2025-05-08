package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothTossPayUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothTossPayBTOBean {

    // 야간부스 토스 페이 가능 여부 DTO 생성
    public ResponseNightBoothTossPayUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothTossPayUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isTossPay(nightBoothDAO.getIsTossPay())
                .build();
    }
}
