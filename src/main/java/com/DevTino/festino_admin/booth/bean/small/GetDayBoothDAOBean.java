package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import com.DevTino.festino_admin.booth.repository.DayBoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDayBoothDAOBean {
    DayBoothRepository dayBoothRepository;

    @Autowired
    public GetDayBoothDAOBean(DayBoothRepository dayBoothRepository) {
        this.dayBoothRepository = dayBoothRepository;
    }

    // 부스아이디로 DAO 찾아서 반환
    public DayBoothDAO exec(UUID boothId) {
        return dayBoothRepository.findById(boothId).orElse(null);
    }
}