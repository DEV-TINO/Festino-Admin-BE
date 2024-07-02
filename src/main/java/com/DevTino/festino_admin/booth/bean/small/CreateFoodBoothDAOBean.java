package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateFoodBoothDAOBean {

    // 푸드트럭 DAO 생성
    public FoodBoothDAO exec(RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {
        return FoodBoothDAO.builder()
                .boothId(UUID.randomUUID())
                .boothName(requestFoodBoothSaveDTO.getBoothName())
                .boothIntro(requestFoodBoothSaveDTO.getBoothIntro())
                .boothImage(requestFoodBoothSaveDTO.getBoothImage())
                .adminName(requestFoodBoothSaveDTO.getAdminName())
                .adminCategory(requestFoodBoothSaveDTO.getAdminCategory())
                .openTime(requestFoodBoothSaveDTO.getOpenTime())
                .closeTime(requestFoodBoothSaveDTO.getCloseTime())
                .location(requestFoodBoothSaveDTO.getLocation())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isOpen(false)
                .build();
    }
}
