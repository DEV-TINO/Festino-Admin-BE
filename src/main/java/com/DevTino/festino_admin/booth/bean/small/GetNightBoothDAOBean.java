package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.booth.repository.NightBoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetNightBoothDAOBean {
    NightBoothRepository nightBoothRepository;

    @Autowired
    public GetNightBoothDAOBean(NightBoothRepository nightBoothRepository) {
        this.nightBoothRepository = nightBoothRepository;
    }

    // 부스 아이디로 DAO 찾아서 반환
    public NightBoothDAO exec(UUID boothId) {
        return nightBoothRepository.findById(boothId).orElse(null);
    }
}
