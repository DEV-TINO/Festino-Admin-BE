package com.DevTino.festino_admin.show.club.bean;

import com.DevTino.festino_admin.show.club.bean.small.GetClubShowDAOBean;
import com.DevTino.festino_admin.show.club.bean.small.SaveClubShowDAOBean;
import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateClubShowBean {

    GetClubShowDAOBean getClubShowDAOBean;
    SaveClubShowDAOBean saveClubShowDAOBean;

    @Autowired
    public UpdateClubShowBean(GetClubShowDAOBean getClubShowDAOBean, SaveClubShowDAOBean saveClubShowDAOBean){
        this.getClubShowDAOBean = getClubShowDAOBean;
        this.saveClubShowDAOBean = saveClubShowDAOBean;
    }



    // 동아리 공연 수정
    public UUID exec(RequestClubShowUpdateDTO requestClubShowUpdateDTO){

        // clubId로 해당 ClubShow DAO 찾기
        ClubShowDAO clubShowDAO = getClubShowDAOBean.exec(requestClubShowUpdateDTO.getClubId());
        if (clubShowDAO == null) return null;

        // DAO 수정
        clubShowDAO.setClubName(requestClubShowUpdateDTO.getClubName());
        clubShowDAO.setShowDate(requestClubShowUpdateDTO.getShowDate());
        clubShowDAO.setShowStartTime(requestClubShowUpdateDTO.getShowStartTime());
        clubShowDAO.setShowEndTime(requestClubShowUpdateDTO.getShowEndTime());
        clubShowDAO.setClubImage(requestClubShowUpdateDTO.getClubImage());

        // DAO 수정 : 수정 시간 저장
        clubShowDAO.setUpdateAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveClubShowDAOBean.exec(clubShowDAO);

        // 수정된 DAO의 clubId 반환
        return clubShowDAO.getClubId();

    }
}
