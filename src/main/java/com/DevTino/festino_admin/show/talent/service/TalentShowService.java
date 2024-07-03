package com.DevTino.festino_admin.show.talent.service;

import com.DevTino.festino_admin.show.talent.bean.SaveTalentShowBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TalentShowService {

    SaveTalentShowBean saveTalentShowBean;

    @Autowired
    public TalentShowService(SaveTalentShowBean saveTalentShowBean){
        this.saveTalentShowBean = saveTalentShowBean;
    }



    // 연예인 공연 저장
    public UUID saveTalentShow(RequestTalentShowSaveDTO requestTalentShowSaveDTO){

        return saveTalentShowBean.exec(requestTalentShowSaveDTO);

    }

}
