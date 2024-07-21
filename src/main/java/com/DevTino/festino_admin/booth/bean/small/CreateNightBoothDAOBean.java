package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class CreateNightBoothDAOBean {

    // 야간부스 DAO 생성
    public NightBoothDAO exec(RequestNightBoothSaveDTO requestNightBoothSaveDTO) {

        // 부스 이미지를 넣지 않았을 때 빈값으로 넣어주는 예외처리
        List<String> boothImage = new ArrayList<>();
        if (requestNightBoothSaveDTO.getBoothImage().isEmpty())
            boothImage = Collections.singletonList("");
        else
            boothImage = requestNightBoothSaveDTO.getBoothImage();

        return NightBoothDAO.builder()
                .boothId(UUID.randomUUID())
                .boothName(requestNightBoothSaveDTO.getBoothName())
                .boothIntro(requestNightBoothSaveDTO.getBoothIntro())
                .boothImage(boothImage)
                .adminName(requestNightBoothSaveDTO.getAdminName())
                .adminCategory(requestNightBoothSaveDTO.getAdminCategory())
                .openTime(requestNightBoothSaveDTO.getOpenTime())
                .closeTime(requestNightBoothSaveDTO.getCloseTime())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isOpen(requestNightBoothSaveDTO.getIsOpen())
                .isOrder(requestNightBoothSaveDTO.getIsOrder())
                .isReservation(requestNightBoothSaveDTO.getIsReservation())
                .totalReservationNum(0)
                .build();
    }
}
