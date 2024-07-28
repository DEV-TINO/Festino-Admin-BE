package com.DevTino.festino_admin.date.Controller;

import com.DevTino.festino_admin.date.Service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    DateService dateService;

    @Autowired
    public DateController(DateService dateService){
        this.dateService = dateService;
    }

    // date(일차 수) 조회
    @GetMapping("/admin/date")
    public Integer getDate(){

        // 일차 수 조회 service 실행해 반환
        return dateService.getDate();

    }
}
