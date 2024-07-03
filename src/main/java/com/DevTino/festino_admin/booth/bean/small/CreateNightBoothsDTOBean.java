package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothsGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateNightBoothsDTOBean {

    // 야간부스 DTO 리스트 생성해서 반환
    public List<ResponseNightBoothsGetDTO> exec(List<NightBoothDAO> nightBoothDAOList) {

        // DTO 리스트 생성
        List<ResponseNightBoothsGetDTO> responseNightBoothsGetDTOList = new ArrayList<>();

        // for문을 이용해 DAO 객체를 하나씩 꺼내 DTO에 삽입
        for(NightBoothDAO nightBoothDAO : nightBoothDAOList) {

            // DTO 생성
            ResponseNightBoothsGetDTO responseNightBoothsGetDTO = ResponseNightBoothsGetDTO.builder()
                    .boothId(nightBoothDAO.getBoothId())
                    .boothName(nightBoothDAO.getBoothName())
                    .adminCategory(nightBoothDAO.getAdminCategory())
                    .adminName(nightBoothDAO.getAdminName())
                    .openTime(nightBoothDAO.getOpenTime())
                    .closeTime(nightBoothDAO.getCloseTime())
                    .isOpen(nightBoothDAO.getIsOpen())
                    .isOrder(nightBoothDAO.getIsOrder())
                    .isReservation(nightBoothDAO.getIsReservation())
                    .build();

            // DTO 리스트에 각 DTO 추가
            responseNightBoothsGetDTOList.add(responseNightBoothsGetDTO);
        }

        // DTO 리스트 반환
        return responseNightBoothsGetDTOList;
    }
}
