package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothKakaoPayUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothKakaoPayBTOBean {
    // 야간부스 카카오페이 가능 여부 DTO 생성
    public ResponseNightBoothKakaoPayUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothKakaoPayUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isKakaoPay(nightBoothDAO.getIsKakaoPay())
                .build();
    }
}
