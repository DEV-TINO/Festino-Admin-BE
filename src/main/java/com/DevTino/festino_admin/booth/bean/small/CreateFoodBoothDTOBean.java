package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateFoodBoothDTOBean {

    // 푸드트럭 DTO 생성
    public ResponseFoodBoothGetDTO exec(FoodBoothDAO foodBoothDAO) {
        return ResponseFoodBoothGetDTO.builder()
                .boothId(foodBoothDAO.getBoothId())
                .boothName(foodBoothDAO.getBoothName())
                .boothImage(foodBoothDAO.getBoothImage())
                .boothIntro(foodBoothDAO.getBoothIntro())
                .openTime(foodBoothDAO.getOpenTime())
                .closeTime(foodBoothDAO.getCloseTime())
                .location(foodBoothDAO.getLocation())
                .descriptImage(foodBoothDAO.getDescriptImage())
                .isOpen(foodBoothDAO.getIsOpen())
                .build();
    }
}
