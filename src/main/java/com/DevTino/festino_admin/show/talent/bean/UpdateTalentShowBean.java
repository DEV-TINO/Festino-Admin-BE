package com.DevTino.festino_admin.show.talent.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.show.talent.bean.small.GetTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.bean.small.SaveTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowUpdateDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateTalentShowBean {

    GetTalentShowDAOBean getTalentShowDAOBean;
    SaveTalentShowDAOBean saveTalentShowDAOBean;

    @Autowired
    public UpdateTalentShowBean(GetTalentShowDAOBean getTalentShowDAOBean, SaveTalentShowDAOBean saveTalentShowDAOBean){
        this.getTalentShowDAOBean = getTalentShowDAOBean;
        this.saveTalentShowDAOBean = saveTalentShowDAOBean;
    }



    // 연예인 공연 수정
    public UUID exec(RequestTalentShowUpdateDTO requestTalentShowUpdateDTO){

        // talentId로 해당 TalentShow DAO 찾기
        TalentShowDAO talentShowDAO = getTalentShowDAOBean.exec(requestTalentShowUpdateDTO.getTalentId());

        // DAO 수정
        talentShowDAO.setTalentId(requestTalentShowUpdateDTO.getTalentId());
        talentShowDAO.setTalentName(requestTalentShowUpdateDTO.getTalentName());
        talentShowDAO.setTalentImage(requestTalentShowUpdateDTO.getTalentImage());
        talentShowDAO.setShowDate(requestTalentShowUpdateDTO.getShowDate());
        talentShowDAO.setShowStartTime(requestTalentShowUpdateDTO.getShowStartTime());
        talentShowDAO.setShowEndTime(requestTalentShowUpdateDTO.getShowEndTime());

        // DAO 수정 : 수정 시간 저장
        talentShowDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정된 DAO 저장
        saveTalentShowDAOBean.exec(talentShowDAO);

        // 수정된 DAO의 talentId 반환
        return talentShowDAO.getTalentId();

    }

}
