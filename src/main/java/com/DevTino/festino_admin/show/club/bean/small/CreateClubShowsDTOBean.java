package com.DevTino.festino_admin.show.club.bean.small;

import com.DevTino.festino_admin.show.club.domain.ClubShowDAO;
import com.DevTino.festino_admin.show.club.domain.DTO.ResponseClubShowGetDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public class CreateClubShowsDTOBean {

    static String zero_sec = ":00";

    // 동아리 공연 DTO List 생성
    public List<ResponseClubShowGetDTO> exec(List<ClubShowDAO> clubShowDAOList){

        // DTO 리스트 생성
        List<ResponseClubShowGetDTO> clubShowDTOList = new ArrayList<>();

        // DAO 리스트에서 DAO 하나씩 꺼내서
        for (ClubShowDAO clubShowDAO : clubShowDAOList){

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

            // DTO 생성 -> DAO 값으로 설정
            ResponseClubShowGetDTO dto = ResponseClubShowGetDTO.builder()
                    .clubId(clubShowDAO.getClubId())
                    .clubName(clubShowDAO.getClubName())
                    .showDate(clubShowDAO.getShowDate())
                    .showStartTime(clubShowDAO.getShowStartTime())
                    .showEndTime(clubShowDAO.getShowEndTime())
                    .isShowing(isShowing)
                    .clubImage(clubShowDAO.getClubImage())
                    .build();

            // 생성한 DTO를 DTO 리스트에 삽입
            clubShowDTOList.add(dto);

        }

        // 생성한 DTO 리스트 리턴
        return clubShowDTOList;
    }

}
