package com.DevTino.festino_admin.show.club.bean;

import com.DevTino.festino_admin.show.club.bean.small.DeleteClubShowDAOBean;
import com.DevTino.festino_admin.show.club.bean.small.GetClubShowDAOBean;
import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteClubShowBean {

    GetClubShowDAOBean getClubShowDAOBean;
    DeleteClubShowDAOBean deleteClubShowDAOBean;

    @Autowired
    public DeleteClubShowBean(GetClubShowDAOBean getClubShowDAOBean, DeleteClubShowDAOBean deleteClubShowDAOBean){
        this.getClubShowDAOBean = getClubShowDAOBean;
        this.deleteClubShowDAOBean = deleteClubShowDAOBean;
    }



    // 동아리 공연 삭제
    public boolean exec(RequestClubShowDeleteDTO requestClubShowDeleteDTO){

        // clubId로 해당 ClubShow DAO 찾기
        ClubShowDAO clubShowDAO = getClubShowDAOBean.exec(requestClubShowDeleteDTO.getClubId());
        if (clubShowDAO == null) return false;

        // DAO 삭제
        deleteClubShowDAOBean.exec(clubShowDAO);
        return true;

    }

}
