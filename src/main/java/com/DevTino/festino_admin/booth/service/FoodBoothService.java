package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.GetFoodBoothBean;
import com.DevTino.festino_admin.booth.bean.SaveFoodBoothBean;
import com.DevTino.festino_admin.booth.bean.UpdateFoodBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FoodBoothService {
    SaveFoodBoothBean saveFoodBoothBean;
    UpdateFoodBoothBean updateFoodBoothBean;
    GetFoodBoothBean getFoodBoothBean;

    @Autowired
    public FoodBoothService(SaveFoodBoothBean saveFoodBoothBean, UpdateFoodBoothBean updateFoodBoothBean, GetFoodBoothBean getFoodBoothBean) {
        this.saveFoodBoothBean = saveFoodBoothBean;
        this.updateFoodBoothBean = updateFoodBoothBean;
        this.getFoodBoothBean = getFoodBoothBean;
    }

    // 푸드트럭 등록
    public UUID saveFoodBooth(RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {
        return saveFoodBoothBean.exec(requestFoodBoothSaveDTO);
    }

    // 푸드트럭 수정
    public UUID updateFoodBooth(RequestFoodBoothUpdateDTO requestFoodBoothUpdateDTO) {
        return updateFoodBoothBean.exec(requestFoodBoothUpdateDTO);
    }

    // 푸드트럭 조회
    public ResponseFoodBoothGetDTO getFoodBooth(UUID boothId) {
        return getFoodBoothBean.exec(boothId);
    }
}
