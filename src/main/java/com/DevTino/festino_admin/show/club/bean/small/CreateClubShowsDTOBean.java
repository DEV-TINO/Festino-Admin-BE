package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.ResponseClubShowGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public class CreateClubShowsDTOBean {

    CreateClubShowDTOBean createClubShowDTOBean;

    @Autowired
    public CreateClubShowsDTOBean(CreateClubShowDTOBean createClubShowDTOBean){
        this.createClubShowDTOBean = createClubShowDTOBean;
    }



    // 동아리 공연 DTO List 생성
    public List<ResponseClubShowGetDTO> exec(List<ClubShowDAO> clubShowDAOList){

        // DTO 리스트 생성
        List<ResponseClubShowGetDTO> clubShowDTOList = new ArrayList<>();

        // DAO 리스트에서 DAO 하나씩 꺼내서
        for (ClubShowDAO clubShowDAO : clubShowDAOList){

            // 동아리 공연 DTO 생성
            ResponseClubShowGetDTO dto = createClubShowDTOBean.exec(clubShowDAO);

            // 생성한 DTO를 DTO 리스트에 삽입
            clubShowDTOList.add(dto);

        }

        // 생성한 DTO 리스트 리턴
        return clubShowDTOList;
    }

}
