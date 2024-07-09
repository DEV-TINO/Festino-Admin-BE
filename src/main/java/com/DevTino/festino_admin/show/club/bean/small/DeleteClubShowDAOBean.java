package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.repository.ClubShowRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteClubShowDAOBean {

    ClubShowRepositoryJPA clubShowRepositoryJPA;

    @Autowired
    public DeleteClubShowDAOBean(ClubShowRepositoryJPA clubShowRepositoryJPA){
        this.clubShowRepositoryJPA = clubShowRepositoryJPA;

    }



    // DB에서 DAO 삭제
    public void exec(ClubShowDAO clubShowDAO){

        clubShowRepositoryJPA.delete(clubShowDAO);

    }

}
