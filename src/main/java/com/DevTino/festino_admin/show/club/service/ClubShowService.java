package com.DevTino.festino_admin.show.club.service;

import com.DevTino.festino_admin.show.club.bean.SaveClubShowBean;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClubShowService {

    SaveClubShowBean saveClubShowBean;

    @Autowired
    public ClubShowService(SaveClubShowBean saveClubShowBean){
        this.saveClubShowBean = saveClubShowBean;
    }

    // 동아리 공연 저장
    public UUID saveClubShow(RequestClubShowSaveDTO requestClubShowSaveDTO){

        return saveClubShowBean.exec(requestClubShowSaveDTO);

    }

}
