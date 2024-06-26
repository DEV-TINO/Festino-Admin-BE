package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import com.DevTino.festino_admin.booth.repository.FoodBoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetFoodBoothDAOBean {
    FoodBoothRepository foodBoothRepository;

    @Autowired
    public GetFoodBoothDAOBean(FoodBoothRepository foodBoothRepository) {
        this.foodBoothRepository = foodBoothRepository;
    }

    // 부스 아이디로 DAO 찾아서 반환
    public FoodBoothDAO exec(UUID boothId) {
        return foodBoothRepository.findById(boothId).orElse(null);
    }
}