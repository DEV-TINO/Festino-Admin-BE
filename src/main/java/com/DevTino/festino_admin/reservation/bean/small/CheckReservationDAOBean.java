package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CheckReservationDAOBean {

    GetNightBoothDAOBean getNightBoothDAOBean;

    @Autowired
    public CheckReservationDAOBean(GetNightBoothDAOBean getNightBoothDAOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
    }

    // 부스의 오픈 시간을 활용해서 몇일차인지 구함
    public Integer exec(UUID boothId) {
        // boothId를 통해 원하는 부스 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(boothId);
        if(nightBoothDAO == null) return null;

        String openTime = nightBoothDAO.getOpenTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime open = LocalTime.parse(openTime, formatter).minusHours(1);

        LocalDateTime start11 = LocalDateTime.of(LocalDate.of(2024, 9, 11), open);
        LocalDateTime start12 = LocalDateTime.of(LocalDate.of(2024, 9, 12), open);
        LocalDateTime start13 = LocalDateTime.of(LocalDate.of(2024, 9, 13), open);

        LocalDateTime end11 = start11.plusHours(12);
        LocalDateTime end12 = start12.plusHours(12);
        LocalDateTime end13 = start13.plusHours(12);

        // 서버 시간 고려 9시간 더해줌
        LocalDateTime now = LocalDateTime.now().plusHours(9);

        Integer date = 0;

        if(now.isAfter(start11) && now.isBefore(end11)) {
            date = 1;
        } else if(now.isAfter(start12) && now.isBefore(end12)) {
            date = 2;
        } else if(now.isAfter(start13) && now.isBefore(end13)) {
            date = 3;
        }

        return date;
    }
}
