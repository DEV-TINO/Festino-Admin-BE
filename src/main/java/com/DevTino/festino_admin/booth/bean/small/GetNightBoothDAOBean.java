package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.booth.repository.NightBoothRepositoryJPA;
import jakarta.persistence.LockModeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class GetNightBoothDAOBean {
    NightBoothRepositoryJPA nightBoothRepository;

    @Autowired
    public GetNightBoothDAOBean(NightBoothRepositoryJPA nightBoothRepository) {
        this.nightBoothRepository = nightBoothRepository;
    }

    // 부스 아이디로 DAO 찾아서 반환
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public NightBoothDAO exec(UUID boothId) {
        return nightBoothRepository.findById(boothId).orElse(null);
    }

    // 전체 DAO 반환
    public List<NightBoothDAO> exec() {
        return nightBoothRepository.findAll();
    }

    // adminName으로 DAO 찾아서 반환
    public NightBoothDAO exec(String adminName) { return nightBoothRepository.findByAdminName(adminName); }
}
