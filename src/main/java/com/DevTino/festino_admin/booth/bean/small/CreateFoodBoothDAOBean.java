package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CreateFoodBoothDAOBean {

    // 푸드트럭 DAO 생성
    public FoodBoothDAO exec(RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {

        // 부스 이미지를 넣지 않았을 때 빈값으로 넣어주는 예외처리
        List<String> boothImage = new ArrayList<>();
        if (requestFoodBoothSaveDTO.getBoothImage() != null)
            boothImage = requestFoodBoothSaveDTO.getBoothImage();

        return FoodBoothDAO.builder()
                .boothId(UUID.randomUUID())
                .boothName(requestFoodBoothSaveDTO.getBoothName())
                .boothIntro(requestFoodBoothSaveDTO.getBoothIntro())
                .boothImage(boothImage)
                .adminName(requestFoodBoothSaveDTO.getAdminName())
                .adminCategory(requestFoodBoothSaveDTO.getAdminCategory())
                .openTime(requestFoodBoothSaveDTO.getOpenTime())
                .closeTime(requestFoodBoothSaveDTO.getCloseTime())
                .location(requestFoodBoothSaveDTO.getLocation())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isOpen(requestFoodBoothSaveDTO.getIsOpen())
                .build();
    }
}
