package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateTalentShowsDTOBean {

    static String zero_sec = ":00";

    // 연예인 공연 DTO List 생성
    public List<ResponseTalentShowGetDTO> exec(List<TalentShowDAO> talentShowDAOList){

        // DTO 리스트 생성
        List<ResponseTalentShowGetDTO> talentShowDTOList = new ArrayList<>();

        // DAO 리스트에서 DAO 하나씩 꺼내서
        for (TalentShowDAO talentShowDAO : talentShowDAOList){

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

            // DTO 생성 -> DAO 값으로 설정
            ResponseTalentShowGetDTO dto = ResponseTalentShowGetDTO.builder()
                    .talentId(talentShowDAO.getTalentId())
                    .talentName(talentShowDAO.getTalentName())
                    .talentImage(talentShowDAO.getTalentImage())
                    .showDate(talentShowDAO.getShowDate())
                    .showStartTime(talentShowDAO.getShowStartTime())
                    .showEndTime(talentShowDAO.getShowEndTime())
                    .isShowing(isShowing)
                    .musicList(talentShowDAO.getMusicList())
                    .build();

            // 생성한 DTO를 DTO 리스트에 삽입
            talentShowDTOList.add(dto);

        }

        // 생성한 DTO 리스트 리턴
        return talentShowDTOList;
    }

}
