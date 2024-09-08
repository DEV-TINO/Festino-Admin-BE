package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateTalentShowDAOBean {

    // 연예인 공연 DAO 생성해 반환
    public TalentShowDAO exec(RequestTalentShowSaveDTO requestTalentShowSaveDTO){

        return TalentShowDAO.builder()
                .talentId(UUID.randomUUID())
                .talentName(requestTalentShowSaveDTO.getTalentName())
                .talentImage(requestTalentShowSaveDTO.getTalentImage())
                .showDate(requestTalentShowSaveDTO.getShowDate())
                .showStartTime(requestTalentShowSaveDTO.getShowStartTime())
                .showEndTime(requestTalentShowSaveDTO.getShowEndTime())
                .musicList(requestTalentShowSaveDTO.getMusicList())
                .createAt(DateTimeUtils.nowZone())
                .updateAt(DateTimeUtils.nowZone())
                .build();

    }

}
