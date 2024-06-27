package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateNightBoothDAOBean {

    // 야간부스 DAO 생성
    public NightBoothDAO exec(RequestNightBoothSaveDTO requestNightBoothSaveDTO) {
        return NightBoothDAO.builder()
                .boothId(UUID.randomUUID())
                .boothName(requestNightBoothSaveDTO.getBoothName())
                .boothIntro(requestNightBoothSaveDTO.getBoothIntro())
                .boothImage(requestNightBoothSaveDTO.getBoothImage())
                .adminName(requestNightBoothSaveDTO.getAdminName())
                .openTime(requestNightBoothSaveDTO.getOpenTime())
                .closeTime(requestNightBoothSaveDTO.getCloseTime())
                .description(requestNightBoothSaveDTO.getDescription())
                .descriptImage(requestNightBoothSaveDTO.getDescriptImage())
                .location(requestNightBoothSaveDTO.getLocation())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isOpen(false)
                .isOrder(requestNightBoothSaveDTO.getIsOrder())
                .totalReservationNum(0)
                .build();
    }
}
