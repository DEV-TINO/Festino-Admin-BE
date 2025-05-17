package com.DevTino.festino_admin.show.talent.bean;

import com.DevTino.festino_admin.show.talent.bean.small.CreateTalentShowDTOBean;
import com.DevTino.festino_admin.show.talent.bean.small.GetTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetTalentShowBean {

    GetTalentShowDAOBean getTalentShowDAOBean;
    CreateTalentShowDTOBean createTalentShowDTOBean;

    @Autowired
    public GetTalentShowBean(GetTalentShowDAOBean getTalentShowDAOBean, CreateTalentShowDTOBean createTalentShowDTOBean){
        this.getTalentShowDAOBean = getTalentShowDAOBean;
        this.createTalentShowDTOBean = createTalentShowDTOBean;
    }



    // 연예인 공연 조회
    public ResponseTalentShowGetDTO exec(UUID talentId){

        // talentId로 해당 TalentShow DAO 찾기
        TalentShowDAO talentShowDAO = getTalentShowDAOBean.exec(talentId);

        // DTO 생성해서 반환
        return createTalentShowDTOBean.exec(talentShowDAO);

    }

}
