package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothsGetDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateDayBoothsDTOBean {

    // 주간부스 DTO 리스트 생성해서 반환
    public List<ResponseDayBoothsGetDTO> exec(List<DayBoothDAO> dayBoothDAOList) {
        // DTO 리스트 생성
        List<ResponseDayBoothsGetDTO> responseDayBoothsGetDTOList = new ArrayList<>();

        // for문을 이용해 DAO 객체를 하나씩 꺼내 DTO에 삽입
        for(DayBoothDAO dayBoothDAO : dayBoothDAOList) {
            // DTO 생성
            ResponseDayBoothsGetDTO responseDayBoothsGetDTO = ResponseDayBoothsGetDTO.builder()
                    .boothId(dayBoothDAO.getBoothId())
                    .adminCategory(dayBoothDAO.getAdminCategory())
                    .adminName(dayBoothDAO.getAdminName())
                    .boothName(dayBoothDAO.getBoothName())
                    .openTime(dayBoothDAO.getOpenTime())
                    .closeTime(dayBoothDAO.getCloseTime())
                    .location(dayBoothDAO.getLocation())
                    .markerNum(dayBoothDAO.getMarkerNum())
                    .isOpen(dayBoothDAO.getIsOpen())
                    .build();

            // DTO 리스트에 각 DTO 추가
            responseDayBoothsGetDTOList.add(responseDayBoothsGetDTO);
        }

        // DTO 리스트 반환
        return responseDayBoothsGetDTOList;
    }
}
