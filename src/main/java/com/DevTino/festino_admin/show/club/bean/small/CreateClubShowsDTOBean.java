package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.damain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.damain.DTO.ResponseClubShowGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreateClubShowsDTOBean {

    public List<ResponseClubShowGetDTO> exec(List<ClubShowDAO> clubShowDAOList){

        // DTO 리스트 생성
        List<ResponseClubShowGetDTO> clubShowDTOList = new ArrayList<>();

        // DAO 리스트에서 DAO 하나씩 꺼내서
        for (ClubShowDAO clubShowDAO : clubShowDAOList){

            // DTO 생성 -> DAO 값으로 설정
            ResponseClubShowGetDTO dto = ResponseClubShowGetDTO.builder()
                    .clubId(clubShowDAO.getClubId())
                    .clubName(clubShowDAO.getClubName())
                    .showDate(clubShowDAO.getShowDate())
                    .showStartTime(clubShowDAO.getShowStartTime())
                    .showEndTime(clubShowDAO.getShowEndTime())
                    .clubImage(clubShowDAO.getClubImage())
                    .build();

            // 생성한 DTO를 DTO 리스트에 삽입
            clubShowDTOList.add(dto);

        }

        // 생성한 DTO 리스트 리턴
        return clubShowDTOList;
    }

}
