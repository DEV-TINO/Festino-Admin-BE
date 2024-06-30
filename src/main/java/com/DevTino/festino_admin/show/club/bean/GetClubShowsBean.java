package com.DevTino.festino_admin.show.club.bean;

import com.DevTino.festino_admin.show.club.bean.small.CreateClubShowsDTOBean;
import com.DevTino.festino_admin.show.club.bean.small.GetClubShowDAOBean;
import com.DevTino.festino_admin.show.club.damain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.damain.DTO.ResponseClubShowGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClubShowsBean {

    GetClubShowDAOBean getClubShowDAOBean;
    CreateClubShowsDTOBean createClubShowsDTOBean;

    @Autowired
    public GetClubShowsBean(GetClubShowDAOBean getClubShowDAOBean, CreateClubShowsDTOBean createClubShowsDTOBean){
        this.getClubShowDAOBean = getClubShowDAOBean;
        this.createClubShowsDTOBean = createClubShowsDTOBean;
    }




    // 동아리 공연 전체 조회
    public List<ResponseClubShowGetDTO> exec(){

        // 동아리 공연 DAO 전체 검색 -> clubShowDAOList
        List<ClubShowDAO> clubShowDAOList = getClubShowDAOBean.exec();
        if (clubShowDAOList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해서 리턴
        return createClubShowsDTOBean.exec(clubShowDAOList);

    }

}
