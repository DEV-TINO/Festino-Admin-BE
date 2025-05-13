package com.DevTino.festino_admin.show.club.bean;

import com.DevTino.festino_admin.show.club.bean.small.CreateClubShowDTOBean;
import com.DevTino.festino_admin.show.club.bean.small.GetClubShowDAOBean;
import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.ResponseClubShowGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetClubShowBean {
    
    GetClubShowDAOBean getClubShowDAOBean;
    CreateClubShowDTOBean createClubShowDTOBean;

    @Autowired
    public GetClubShowBean(GetClubShowDAOBean getClubShowDAOBean, CreateClubShowDTOBean createClubShowDTOBean){
        this.getClubShowDAOBean = getClubShowDAOBean;
        this.createClubShowDTOBean = createClubShowDTOBean;
    }

    
    
    // 동아리 공연 조회
    public ResponseClubShowGetDTO exec(UUID clubId){

        // clubId로 해당 ClubShow DAO 찾기
        ClubShowDAO clubShowDAO = getClubShowDAOBean.exec(clubId);

        // DTO 생성해서 반환
        return createClubShowDTOBean.exec(clubShowDAO);

    }

}
