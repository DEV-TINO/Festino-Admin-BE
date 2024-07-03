package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CreateTalentShowDTOBean {

    static String zero_sec = ":00";

    // 연예인 공연 DTO 생성
    public ResponseTalentShowGetDTO exec(TalentShowDAO talentShowDAO){

        // 공연 시작 날짜+시간을 LocalDateTime으로 변경
        LocalDateTime showStart = LocalDateTime
                .parse(talentShowDAO.getShowDate() + talentShowDAO.getShowStartTime() + zero_sec,
                        DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss"));

        // 공연 종료 날짜+시간을 LocalDateTime으로 변경
        LocalDateTime showEnd = LocalDateTime
                .parse(talentShowDAO.getShowDate() + talentShowDAO.getShowEndTime() + zero_sec,
                        DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss"));

        // 공연이 현재 진행 중인지 판단해서 isShowing 설정
        Boolean isShowing =
                LocalDateTime.now().isAfter(showStart) && LocalDateTime.now().isBefore(showEnd);

        // DAO 값으로 설정한 DTO 생성해 반환
        return ResponseTalentShowGetDTO.builder()
                .talentId(talentShowDAO.getTalentId())
                .talentName(talentShowDAO.getTalentName())
                .talentImage(talentShowDAO.getTalentImage())
                .showDate(talentShowDAO.getShowDate())
                .showStartTime(talentShowDAO.getShowStartTime())
                .showEndTime(talentShowDAO.getShowEndTime())
                .isShowing(isShowing)
                .musicList(talentShowDAO.getMusicList())
                .build();

    }
}
