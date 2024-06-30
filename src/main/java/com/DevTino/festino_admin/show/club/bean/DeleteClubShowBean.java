package com.DevTino.festino_admin.show.club.bean;

import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import com.DevTino.festino_admin.show.club.bean.small.DeleteClubShowDAOBean;
import com.DevTino.festino_admin.show.club.bean.small.GetClubShowDAOBean;
import com.DevTino.festino_admin.show.club.damain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowDeleteDTO;
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

        // noticeId로 해당 Notice DAO 찾기
        ClubShowDAO clubShowDAO = getClubShowDAOBean.exec(requestClubShowDeleteDTO.getClubId());
        if (clubShowDAO == null) return false;

        // DAO 삭제
        deleteClubShowDAOBean.exec(clubShowDAO);
        return true;

    }

}
