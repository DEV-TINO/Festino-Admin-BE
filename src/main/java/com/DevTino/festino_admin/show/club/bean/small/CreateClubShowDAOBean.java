package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.damain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowSaveDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateClubShowDAOBean {

    // 동아리 공연 DAO 생성해 반환
    public ClubShowDAO exec(RequestClubShowSaveDTO requestClubShowSaveDTO){

        return ClubShowDAO.builder()
                .clubId(UUID.randomUUID())
                .clubName(requestClubShowSaveDTO.getClubName())
                .showDate(requestClubShowSaveDTO.getShowDate())
                .showStartTime(requestClubShowSaveDTO.getShowStartTime())
                .showEndTime(requestClubShowSaveDTO.getShowEndTime())
                .clubImage(requestClubShowSaveDTO.getClubImage())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

    }
}
