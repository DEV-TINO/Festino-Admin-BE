package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Component
public class CreateDayBoothDAOBean {

    //주간부스 DAO 생성
    public DayBoothDAO exec(RequestDayBoothSaveDTO requestDayBoothSaveDTO) {

        // 부스 이미지를 넣지 않았을 때 빈값으로 넣어주는 예외처리
        List<String> boothImage = new ArrayList<>();
        if (requestDayBoothSaveDTO.getBoothImage().isEmpty())
            boothImage = Collections.singletonList("");
        else
            boothImage = requestDayBoothSaveDTO.getBoothImage();

        return DayBoothDAO.builder()
                .boothId(UUID.randomUUID())
                .boothImage(boothImage)
                .boothIntro(requestDayBoothSaveDTO.getBoothIntro())
                .boothName(requestDayBoothSaveDTO.getBoothName())
                .openTime(requestDayBoothSaveDTO.getOpenTime())
                .closeTime(requestDayBoothSaveDTO.getCloseTime())
                .adminName(requestDayBoothSaveDTO.getAdminName())
                .adminCategory(requestDayBoothSaveDTO.getAdminCategory())
                .createAt(DateTimeUtils.nowZone())
                .updateAt(DateTimeUtils.nowZone())
                .location("")
                .markerNum(0)
                .isOpen(requestDayBoothSaveDTO.getIsOpen())
                .build();
    }
}
