package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothsGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateFoodBoothsDTOBean {

    // 푸드트럭 DTO 리스트 생성해서 반환
    public List<ResponseFoodBoothsGetDTO> exec(List<FoodBoothDAO> foodBoothDAOList) {
        // DTO 리스트 생성
        List<ResponseFoodBoothsGetDTO> responseFoodBoothsGetDTOList = new ArrayList<>();

        // for문을 이용해서 DAO를 하나씩 꺼내 DTO로 삽입
        for(FoodBoothDAO foodBoothDAO : foodBoothDAOList) {
            // DTO 생성
            ResponseFoodBoothsGetDTO responseFoodBoothsGetDTO = ResponseFoodBoothsGetDTO.builder()
                    .boothId(foodBoothDAO.getBoothId())
                    .adminCategory(foodBoothDAO.getAdminCategory())
                    .adminName(foodBoothDAO.getAdminName())
                    .boothName(foodBoothDAO.getBoothName())
                    .openTime(foodBoothDAO.getOpenTime())
                    .closeTime(foodBoothDAO.getCloseTime())
                    .isOpen(foodBoothDAO.getIsOpen())
                    .build();

            // DTO 리스트에 각 DTO 넣기
            responseFoodBoothsGetDTOList.add(responseFoodBoothsGetDTO);
        }

        // DTO 리스트 반환
        return responseFoodBoothsGetDTOList;
    }
}
