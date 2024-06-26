package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetFoodBoothBean {
    GetFoodBoothDAOBean getFoodBoothDAOBean;

    @Autowired
    public GetFoodBoothBean(GetFoodBoothDAOBean getFoodBoothDAOBean) {
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
    }

    public ResponseFoodBoothGetDTO exec(UUID boothId) {

        // 부스아이디를 통해 원하는 객체(DAO) 찾기
        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(boothId);
        if(foodBoothDAO == null) return null;

        // DTO 생성해서 반환
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
