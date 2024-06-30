package com.DevTino.festino_admin.show.club.service;

import com.DevTino.festino_admin.show.club.bean.DeleteClubShowBean;
import com.DevTino.festino_admin.show.club.bean.GetClubShowBean;
import com.DevTino.festino_admin.show.club.bean.SaveClubShowBean;
import com.DevTino.festino_admin.show.club.bean.UpdateClubShowBean;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowDeleteDTO;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowSaveDTO;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowUpdateDTO;
import com.DevTino.festino_admin.show.club.damain.DTO.ResponseClubShowGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClubShowService {

    GetClubShowBean getClubShowBean;
    SaveClubShowBean saveClubShowBean;
    UpdateClubShowBean updateClubShowBean;
    DeleteClubShowBean deleteClubShowBean;

    @Autowired
    public ClubShowService(GetClubShowBean getClubShowBean, SaveClubShowBean saveClubShowBean, UpdateClubShowBean updateClubShowBean, DeleteClubShowBean deleteClubShowBean){
        this.getClubShowBean = getClubShowBean;
        this.saveClubShowBean = saveClubShowBean;
        this.updateClubShowBean = updateClubShowBean;
        this.deleteClubShowBean = deleteClubShowBean;

    }



    // 동아리 공연 조회
    public ResponseClubShowGetDTO getClubShow(UUID clubId){

        return getClubShowBean.exec(clubId);

    }

    // 동아리 공연 저장
    public UUID saveClubShow(RequestClubShowSaveDTO requestClubShowSaveDTO){

        return saveClubShowBean.exec(requestClubShowSaveDTO);

    }

    // 동아리 공연 수정
    public UUID updateClubShow(RequestClubShowUpdateDTO requestClubShowUpdateDTO){

        return updateClubShowBean.exec(requestClubShowUpdateDTO);

    }

    // 동아리 공연 삭제
    public boolean deleteClubShow(RequestClubShowDeleteDTO requestClubShowDeleteDTO){

        return deleteClubShowBean.exec(requestClubShowDeleteDTO);

    }

}
