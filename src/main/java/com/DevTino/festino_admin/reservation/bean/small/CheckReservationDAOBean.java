package com.DevTino.festino_admin.reservation.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class CheckReservationDAOBean {
    // 부스의 오픈 시간을 활용해서 몇일차인지 구함
    public Integer exec(NightBoothDAO nightBoothDAO) {

        // 시작 시간
        LocalDateTime start26 = LocalDateTime.of(LocalDate.of(2025, 5, 26), LocalTime.of(15, 0, 0));
        LocalDateTime start27 = LocalDateTime.of(LocalDate.of(2025, 5, 27), LocalTime.of(15, 0, 0));
        LocalDateTime start28 = LocalDateTime.of(LocalDate.of(2025, 5, 28), LocalTime.of(15, 0, 0));

        // 종료 시간
        LocalDateTime end26 = start26.plusHours(12);
        LocalDateTime end27 = start27.plusHours(12);

        // 서버 시간 고려 9시간 더해줌
        LocalDateTime now = DateTimeUtils.nowZone();

        // 시간에 따라 date 설정
        int date = 0;

        if(now.isAfter(start26) && now.isBefore(end26)) {
            date = 1;
        } else if(now.isAfter(start27) && now.isBefore(end27)) {
            date = 2;
        } else if(now.isAfter(start28)) {
            date = 3;
        }

        return date;
    }
}
