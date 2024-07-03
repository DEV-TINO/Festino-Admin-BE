package com.DevTino.festino_admin.show.talent.service;

import com.DevTino.festino_admin.show.talent.bean.DeleteTalentShowBean;
import com.DevTino.festino_admin.show.talent.bean.GetTalentShowBean;
import com.DevTino.festino_admin.show.talent.bean.SaveTalentShowBean;
import com.DevTino.festino_admin.show.talent.bean.UpdateTalentShowBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowDeleteDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowUpdateDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TalentShowService {

    GetTalentShowBean getTalentShowBean;
    SaveTalentShowBean saveTalentShowBean;
    UpdateTalentShowBean updateTalentShowBean;
    DeleteTalentShowBean deleteTalentShowBean;

    @Autowired
    public TalentShowService(GetTalentShowBean getTalentShowBean, SaveTalentShowBean saveTalentShowBean, UpdateTalentShowBean updateTalentShowBean, DeleteTalentShowBean deleteTalentShowBean){
        this.getTalentShowBean = getTalentShowBean;
        this.saveTalentShowBean = saveTalentShowBean;
        this.updateTalentShowBean = updateTalentShowBean;
        this.deleteTalentShowBean = deleteTalentShowBean;
    }



    // 연예인 공연 조회
    public ResponseTalentShowGetDTO getTalentShow(UUID talentId){

        return getTalentShowBean.exec(talentId);

    }

    // 연예인 공연 저장
    public UUID saveTalentShow(RequestTalentShowSaveDTO requestTalentShowSaveDTO){

        return saveTalentShowBean.exec(requestTalentShowSaveDTO);

    }

    // 연예인 공연 수정
    public UUID updateTalentShow(RequestTalentShowUpdateDTO requestTalentShowUpdateDTO){

        return updateTalentShowBean.exec(requestTalentShowUpdateDTO);

    }

    // 연예인 공연 삭제
    public boolean deleteTalentShow(RequestTalentShowDeleteDTO requestTalentShowDeleteDTO){

        return deleteTalentShowBean.exec(requestTalentShowDeleteDTO);

    }

}
