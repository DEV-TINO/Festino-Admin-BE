package com.DevTino.festino_admin.show.club.service;

import com.DevTino.festino_admin.show.club.bean.*;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowDeleteDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowSaveDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowUpdateDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.ResponseClubShowGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClubShowService {

    GetClubShowBean getClubShowBean;
    GetClubShowsBean getClubShowsBean;
    SaveClubShowBean saveClubShowBean;
    UpdateClubShowBean updateClubShowBean;
    DeleteClubShowBean deleteClubShowBean;

    @Autowired
    public ClubShowService(GetClubShowBean getClubShowBean, GetClubShowsBean getClubShowsBean, SaveClubShowBean saveClubShowBean, UpdateClubShowBean updateClubShowBean, DeleteClubShowBean deleteClubShowBean){
        this.getClubShowBean = getClubShowBean;
        this.getClubShowsBean = getClubShowsBean;
        this.saveClubShowBean = saveClubShowBean;
        this.updateClubShowBean = updateClubShowBean;
        this.deleteClubShowBean = deleteClubShowBean;

    }



    // 동아리 공연 조회
    public ResponseClubShowGetDTO getClubShow(UUID clubId){

        return getClubShowBean.exec(clubId);

    }

    // 동아리 공연 전체 조회
    public List<ResponseClubShowGetDTO> getClubShowAll(){

        return getClubShowsBean.exec();

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
