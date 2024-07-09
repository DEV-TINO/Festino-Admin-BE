package com.DevTino.festino_admin.show.club.bean;

import com.DevTino.festino_admin.show.club.bean.small.CreateClubShowDAOBean;
import com.DevTino.festino_admin.show.club.bean.small.SaveClubShowDAOBean;
import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveClubShowBean {

    CreateClubShowDAOBean createClubShowDAOBean;
    SaveClubShowDAOBean saveClubShowDAOBean;

    @Autowired
    public SaveClubShowBean(CreateClubShowDAOBean createClubShowDAOBean, SaveClubShowDAOBean saveClubShowDAOBean){
        this.createClubShowDAOBean = createClubShowDAOBean;
        this.saveClubShowDAOBean = saveClubShowDAOBean;
    }



    // 동아리 공연 저장
    public UUID exec(RequestClubShowSaveDTO requestClubShowSaveDTO){

        // 동아리 공연 DAO 객체 생성
        ClubShowDAO clubShowDAO = createClubShowDAOBean.exec(requestClubShowSaveDTO);
        if (clubShowDAO == null) return null;

        // DAO 저장
        saveClubShowDAOBean.exec(clubShowDAO);

        // DAO의 PK 리턴
        return clubShowDAO.getClubId();

    }

}
