package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.booth.bean.small.CreateFoodBoothOpenDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothUpdateDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class UpdateFoodBoothBean {
    GetFoodBoothDAOBean getFoodBoothDAOBean;
    SaveFoodBoothDAOBean saveFoodBoothDAOBean;

    @Autowired
    public UpdateFoodBoothBean(GetFoodBoothDAOBean getFoodBoothDAOBean, SaveFoodBoothDAOBean saveFoodBoothDAOBean, CreateFoodBoothOpenDTOBean createFoodBoothOpenDTOBean) {
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
        this.saveFoodBoothDAOBean = saveFoodBoothDAOBean;
    }

    // 푸드트럭 수정
    public UUID exec(RequestFoodBoothUpdateDTO requestFoodBoothUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(requestFoodBoothUpdateDTO.getBoothId());

        // 부스 이미지를 넣지 않았을 때 빈값으로 넣어주는 예외처리
        List<String> boothImage = new ArrayList<>();
        if (requestFoodBoothUpdateDTO.getBoothImage().isEmpty())
            boothImage = Collections.singletonList("");
        else
            boothImage = requestFoodBoothUpdateDTO.getBoothImage();

        // DAO 수정
        foodBoothDAO.setBoothName(requestFoodBoothUpdateDTO.getBoothName());
        foodBoothDAO.setBoothIntro(requestFoodBoothUpdateDTO.getBoothIntro());
        foodBoothDAO.setBoothImage(boothImage);
        foodBoothDAO.setAdminName(requestFoodBoothUpdateDTO.getAdminName());
        foodBoothDAO.setAdminCategory(requestFoodBoothUpdateDTO.getAdminCategory());
        foodBoothDAO.setOpenTime(requestFoodBoothUpdateDTO.getOpenTime());
        foodBoothDAO.setCloseTime(requestFoodBoothUpdateDTO.getCloseTime());
        foodBoothDAO.setIsOpen(requestFoodBoothUpdateDTO.getIsOpen());

        foodBoothDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정된 DAO 저장
        saveFoodBoothDAOBean.exec(foodBoothDAO);

        // 키값 반환
        return foodBoothDAO.getBoothId();
    }
}
