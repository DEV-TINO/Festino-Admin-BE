package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.repository.ClubShowRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveClubShowDAOBean {

    ClubShowRepositoryJPA clubShowRepositoryJPA;

    @Autowired
    public SaveClubShowDAOBean(ClubShowRepositoryJPA clubShowRepositoryJPA){
        this.clubShowRepositoryJPA = clubShowRepositoryJPA;
    }



    // 동아리 공연 DAO를 DB에 저장
    public void exec(ClubShowDAO clubShowDAO){

        clubShowRepositoryJPA.save(clubShowDAO);

    }

}
