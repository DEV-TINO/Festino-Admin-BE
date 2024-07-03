package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.damain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.damain.DTO.ResponseClubShowGetDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CreateClubShowDTOBean {

    static String zero_sec = ":00";

    // 동아리 공연 DTO 생성
    public ResponseClubShowGetDTO exec(ClubShowDAO clubShowDAO){

        // 공연 시작 날짜+시간을 LocalDateTime으로 변경
        LocalDateTime showStart = LocalDateTime
                .parse(clubShowDAO.getShowDate() + clubShowDAO.getShowStartTime() + zero_sec,
                        DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss"));

        // 공연 종료 날짜+시간을 LocalDateTime으로 변경
        LocalDateTime showEnd = LocalDateTime
                .parse(clubShowDAO.getShowDate() + clubShowDAO.getShowEndTime() + zero_sec,
                        DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss"));

        // 공연이 현재 진행 중인지 판단해서 isShowing 설정
        Boolean isShowing =
                LocalDateTime.now().isAfter(showStart) && LocalDateTime.now().isBefore(showEnd);

        // DAO 값으로 설정한 DTO 생성해 반환
        return ResponseClubShowGetDTO.builder()
                .clubId(UUID.randomUUID())
                .clubName(clubShowDAO.getClubName())
                .showDate(clubShowDAO.getShowDate())
                .showStartTime(clubShowDAO.getShowStartTime())
                .showEndTime(clubShowDAO.getShowEndTime())
                .isShowing(isShowing)
                .clubImage(clubShowDAO.getClubImage())
                .build();

    }

}
