package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;


@Component
public class CreateDayBoothDAOBean {

    //주간부스 DAO 생성
    public DayBoothDAO exec(RequestDayBoothSaveDTO requestDayBoothSaveDTO) {
        return DayBoothDAO.builder()
                .boothId(UUID.randomUUID())
                .boothImage(requestDayBoothSaveDTO.getBoothImage())
                .boothIntro(requestDayBoothSaveDTO.getBoothIntro())
                .boothName(requestDayBoothSaveDTO.getBoothName())
                .openTime(requestDayBoothSaveDTO.getOpenTime())
                .closeTime(requestDayBoothSaveDTO.getCloseTime())
                .location(requestDayBoothSaveDTO.getLocation())
                .adminName(requestDayBoothSaveDTO.getAdminName())
                .adminCategory(requestDayBoothSaveDTO.getAdminCategory())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isOpen(false)
                .build();
    }
}
