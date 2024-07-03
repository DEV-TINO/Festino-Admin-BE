package com.DevTino.festino_admin.show.talent.bean;

import com.DevTino.festino_admin.show.talent.bean.small.DeleteTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.bean.small.GetTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowDeleteDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTalentShowBean {

    GetTalentShowDAOBean getTalentShowDAOBean;
    DeleteTalentShowDAOBean deleteTalentShowDAOBean;

    @Autowired
    public DeleteTalentShowBean(GetTalentShowDAOBean getTalentShowDAOBean, DeleteTalentShowDAOBean deleteTalentShowDAOBean){
        this.getTalentShowDAOBean = getTalentShowDAOBean;
        this.deleteTalentShowDAOBean = deleteTalentShowDAOBean;
    }



    // 연예인 공연 삭제
    public boolean exec(RequestTalentShowDeleteDTO requestTalentShowDeleteDTO){

        // talentId로 해당 TalentShow DAO 찾기
        TalentShowDAO talentShowDAO = getTalentShowDAOBean.exec(requestTalentShowDeleteDTO.getTalentId());
        if (talentShowDAO == null) return false;

        // DAO 삭제
        deleteTalentShowDAOBean.exec(talentShowDAO);
        return true;

    }
}
