package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNightBoothDTOBean {

    // 야간부스 DTO 생성
    public ResponseNightBoothGetDTO exec(NightBoothDAO nightBoothDAO) {
        return ResponseNightBoothGetDTO.builder()
                .boothId(nightBoothDAO.getBoothId())
                .boothName(nightBoothDAO.getBoothName())
                .boothIntro(nightBoothDAO.getBoothIntro())
                .boothImage(nightBoothDAO.getBoothImage())
                .adminName(nightBoothDAO.getAdminName())
                .adminCategory(nightBoothDAO.getAdminCategory())
                .location(nightBoothDAO.getLocation())
                .openTime(nightBoothDAO.getOpenTime())
                .closeTime(nightBoothDAO.getCloseTime())
                .isOpen(nightBoothDAO.getIsOpen())
                .isOrder(nightBoothDAO.getIsOrder())
                .totalReservationNum(nightBoothDAO.getTotalReservationNum())
                .build();
    }
}