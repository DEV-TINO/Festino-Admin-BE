package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothOpenGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateFoodBoothOpenDTOBean {

    // 푸드트럭 운영 중 DTO 생성
    public ResponseFoodBoothOpenGetDTO exec(FoodBoothDAO foodBoothDAO) {
        return ResponseFoodBoothOpenGetDTO.builder()
                .boothId(foodBoothDAO.getBoothId())
                .isOpen(foodBoothDAO.getIsOpen())
                .build();
    }
}
