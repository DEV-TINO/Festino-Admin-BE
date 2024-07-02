package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.damain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.damain.DTO.ResponseClubShowGetDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateClubShowDTOBean {

    // 동아리 공연 DTO 생성
    public ResponseClubShowGetDTO exec(ClubShowDAO clubShowDAO){

        // DAO 값으로 설정한 DTO 생성해 반환
        return ResponseClubShowGetDTO.builder()
                .clubId(UUID.randomUUID())
                .clubName(clubShowDAO.getClubName())
                .showDate(clubShowDAO.getShowDate())
                .showStartTime(clubShowDAO.getShowStartTime())
                .showEndTime(clubShowDAO.getShowEndTime())
                .clubImage(clubShowDAO.getClubImage())
                .build();

    }

}
