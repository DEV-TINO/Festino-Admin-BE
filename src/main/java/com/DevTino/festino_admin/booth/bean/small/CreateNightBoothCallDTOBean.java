package com.DevTino.festino_admin.booth.bean.small;


import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothCallUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothReservationUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothCallDTOBean {

    public ResponseNightBoothCallUpdateDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothCallUpdateDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .isCall(nightBoothDAO.getIsCall())
                .build();
    }
}
