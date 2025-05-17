package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.repository.ClubShowRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetClubShowDAOBean {

    ClubShowRepositoryJPA clubShowRepositoryJPA;

    @Autowired
    public GetClubShowDAOBean(ClubShowRepositoryJPA clubShowRepositoryJPA){
        this.clubShowRepositoryJPA = clubShowRepositoryJPA;
    }



    // clubId로 DAO 찾아서 반환
    public ClubShowDAO exec(UUID clubId){

        ClubShowDAO dao = clubShowRepositoryJPA.findById(clubId).orElse(null);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // 동아리 공연 DAO 전체 검색해서 반환
    public List<ClubShowDAO> exec(){

        List<ClubShowDAO> daoList = clubShowRepositoryJPA.findAll();
        if (daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;

    }

}
