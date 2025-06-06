package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import com.DevTino.festino_admin.show.talent.repository.TalentShowRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetTalentShowDAOBean {

    TalentShowRepositoryJPA talentShowRepositoryJPA;

    @Autowired
    public GetTalentShowDAOBean(TalentShowRepositoryJPA talentShowRepositoryJPA){
        this.talentShowRepositoryJPA = talentShowRepositoryJPA;
    }



    // talentId로 DAO 찾아서 반환
    public TalentShowDAO exec(UUID talentId){

        TalentShowDAO dao = talentShowRepositoryJPA.findById(talentId).orElse(null);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // 연예인 공연 DAO 전체 검색해서 반환
    public List<TalentShowDAO> exec(){

        List<TalentShowDAO> daoList = talentShowRepositoryJPA.findAll();
        if (daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;
        
    }

}
