package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowSaveDTO;
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
                .createAt(DateTimeUtils.nowZone())
                .updateAt(DateTimeUtils.nowZone())
                .build();

    }
}
