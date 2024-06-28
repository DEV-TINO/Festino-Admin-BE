package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.booth.repository.NightBoothRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveNightBoothDAOBean {
    NightBoothRepositoryJPA nightBoothRepository;

    @Autowired
    public SaveNightBoothDAOBean(NightBoothRepositoryJPA nightBoothRepository) {
        this.nightBoothRepository = nightBoothRepository;
    }

    // 야간부스 DAO를 DB에 저장
    public void exec(NightBoothDAO nightBoothDAO) {
        nightBoothRepository.save(nightBoothDAO);
    }
}
