package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateFoodBoothOpenDTOBean {

    // 푸드트럭 운영 중 DTO 생성
    public ResponseFoodBoothOpenUpdateDTO exec(FoodBoothDAO foodBoothDAO) {
        return ResponseFoodBoothOpenUpdateDTO.builder()
                .boothId(foodBoothDAO.getBoothId())
                .isOpen(foodBoothDAO.getIsOpen())
                .build();
    }
}
