package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class GetDateBean {

    // date(일차 수) 조회
    public Integer exec(){

        // 시작 시간
        LocalDateTime start11 = LocalDateTime.of(LocalDate.of(2024, 9, 11), LocalTime.of(14, 0, 0));
        LocalDateTime start12 = LocalDateTime.of(LocalDate.of(2024, 9, 12), LocalTime.of(14, 0, 0));
        LocalDateTime start13 = LocalDateTime.of(LocalDate.of(2024, 9, 13), LocalTime.of(14, 0, 0));

        // 종료 시간
        LocalDateTime end11 = start11.plusHours(18);
        LocalDateTime end12 = start12.plusHours(18);

        // 서버 시간 고려 9시간 더해줌
        LocalDateTime now = DateTimeUtils.nowZone();

        // 시간에 따라 date 설정
        Integer date = 0;

        if(now.isAfter(start11) && now.isBefore(end11)) {
            date = 1;
        } else if(now.isAfter(start12) && now.isBefore(end12)) {
            date = 2;
        } else if(now.isAfter(start13)) {
            date = 3;
        }

        return date;
        
    }

}
