package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import com.DevTino.festino_admin.show.talent.repository.TalentShowRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTalentShowDAOBean {

    TalentShowRepositoryJPA talentShowRepositoryJPA;

    @Autowired
    public SaveTalentShowDAOBean(TalentShowRepositoryJPA talentShowRepositoryJP){
        this.talentShowRepositoryJPA = talentShowRepositoryJP;
    }



    // 연예인 공연 DAO를 DB에 저장
    public void exec(TalentShowDAO talentShowDAO){

        talentShowRepositoryJPA.save(talentShowDAO);

    }

}
