package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import com.DevTino.festino_admin.booth.repository.DayBoothRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDayBoothDAOBean {
    DayBoothRepositoryJPA dayBoothRepository;

    @Autowired
    public GetDayBoothDAOBean(DayBoothRepositoryJPA dayBoothRepository) {
        this.dayBoothRepository = dayBoothRepository;
    }

    // 부스아이디로 DAO 찾아서 반환
    public DayBoothDAO exec(UUID boothId) {
        return dayBoothRepository.findById(boothId).orElse(null);
    }
}
