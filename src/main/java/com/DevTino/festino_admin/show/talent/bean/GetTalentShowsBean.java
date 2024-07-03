package com.DevTino.festino_admin.show.talent.bean;

import com.DevTino.festino_admin.show.talent.bean.small.CreateTalentShowsDTOBean;
import com.DevTino.festino_admin.show.talent.bean.small.GetTalentShowDAOBean;
import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTalentShowsBean {

    GetTalentShowDAOBean getTalentShowDAOBean;
    CreateTalentShowsDTOBean createTalentShowsDTOBean;

    @Autowired
    public GetTalentShowsBean(GetTalentShowDAOBean getTalentShowDAOBean, CreateTalentShowsDTOBean createTalentShowsDTOBean){
        this.getTalentShowDAOBean = getTalentShowDAOBean;
        this.createTalentShowsDTOBean = createTalentShowsDTOBean;
    }



    // 연예인 공연 전체 조회
    public List<ResponseTalentShowGetDTO> exec(){

        // 연예인 공연 DAO 전체 검색 -> talentShowDAOList
        List<TalentShowDAO> talentShowDAOList = getTalentShowDAOBean.exec();
        if (talentShowDAOList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해서 리턴
        return createTalentShowsDTOBean.exec(talentShowDAOList);

    }
}
