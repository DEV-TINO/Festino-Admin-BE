package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothOpenGetDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateDayBoothOpenDTOBean {

    // 주간부스 운영 중 DTO 생성
    public ResponseDayBoothOpenGetDTO exec(DayBoothDAO dayBoothDAO) {
        return ResponseDayBoothOpenGetDTO.builder()
                .boothId(dayBoothDAO.getBoothId())
                .isOpen(dayBoothDAO.getIsOpen())
                .build();
    }
}
