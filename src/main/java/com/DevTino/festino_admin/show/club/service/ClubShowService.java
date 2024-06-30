package com.DevTino.festino_admin.show.club.service;

import com.DevTino.festino_admin.show.club.bean.SaveClubShowBean;
import com.DevTino.festino_admin.show.club.bean.UpdateClubShowBean;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowSaveDTO;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClubShowService {

    SaveClubShowBean saveClubShowBean;
    UpdateClubShowBean updateClubShowBean;

    @Autowired
    public ClubShowService(SaveClubShowBean saveClubShowBean, UpdateClubShowBean updateClubShowBean){
        this.saveClubShowBean = saveClubShowBean;
        this.updateClubShowBean = updateClubShowBean;

    }

    // 동아리 공연 저장
    public UUID saveClubShow(RequestClubShowSaveDTO requestClubShowSaveDTO){

        return saveClubShowBean.exec(requestClubShowSaveDTO);

    }

    // 동아리 공연 수정
    public UUID updateClubShow(RequestClubShowUpdateDTO requestClubShowUpdateDTO){

        return updateClubShowBean.exec(requestClubShowUpdateDTO);

    }

}
