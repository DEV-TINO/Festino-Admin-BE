package com.DevTino.festino_admin.show.talent.bean;

import com.DevTino.festino_admin.show.talent.bean.small.CreateTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.bean.small.SaveTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveTalentShowBean {

    CreateTalentShowDAOBean createTalentShowDAOBean;
    SaveTalentShowDAOBean saveTalentShowDAOBean;

    @Autowired
    public SaveTalentShowBean(CreateTalentShowDAOBean createTalentShowDAOBean, SaveTalentShowDAOBean saveTalentShowDAOBean){
        this.createTalentShowDAOBean = createTalentShowDAOBean;
        this.saveTalentShowDAOBean = saveTalentShowDAOBean;
    }



    // 연예인 공연 저장
    public UUID exec(RequestTalentShowSaveDTO requestTalentShowSaveDTO){

        // 연예인 공연 DAO 객체 생성
        TalentShowDAO talentShowDAO = createTalentShowDAOBean.exec(requestTalentShowSaveDTO);
        if (talentShowDAO == null) return null;

        // DAO 저장
        saveTalentShowDAOBean.exec(talentShowDAO);

        // DAO의 PK 리턴
        return talentShowDAO.getTalentId();

    }

}
