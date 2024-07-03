package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import com.DevTino.festino_admin.show.talent.repository.TalentShowRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTalentShowDAOBean {

    TalentShowRepositoryJPA talentShowRepositoryJPA;

    @Autowired
    public DeleteTalentShowDAOBean(TalentShowRepositoryJPA talentShowRepositoryJPA){
        this.talentShowRepositoryJPA = talentShowRepositoryJPA;
    }



    // DB에서 DAO 삭제
    public void exec(TalentShowDAO talentShowDAO){

        talentShowRepositoryJPA.delete(talentShowDAO);

    }

}
