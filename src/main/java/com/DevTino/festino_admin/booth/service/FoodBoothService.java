package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.*;
import com.DevTino.festino_admin.booth.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodBoothService {
    SaveFoodBoothBean saveFoodBoothBean;
    UpdateFoodBoothBean updateFoodBoothBean;
    UpdateFoodBoothOpenBean updateFoodBoothOpenBean;
    GetFoodBoothBean getFoodBoothBean;
    GetFoodBoothsBean getFoodBoothsBean;

    @Autowired
    public FoodBoothService(SaveFoodBoothBean saveFoodBoothBean, UpdateFoodBoothBean updateFoodBoothBean, UpdateFoodBoothOpenBean updateFoodBoothOpenBean, GetFoodBoothBean getFoodBoothBean, GetFoodBoothsBean getFoodBoothsBean) {
        this.saveFoodBoothBean = saveFoodBoothBean;
        this.updateFoodBoothBean = updateFoodBoothBean;
        this.updateFoodBoothOpenBean = updateFoodBoothOpenBean;
        this.getFoodBoothBean = getFoodBoothBean;
        this.getFoodBoothsBean = getFoodBoothsBean;
    }

    // 푸드트럭 등록
    public UUID saveFoodBooth(RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {
        return saveFoodBoothBean.exec(requestFoodBoothSaveDTO);
    }

    // 푸드트럭 수정
    public UUID updateFoodBooth(RequestFoodBoothUpdateDTO requestFoodBoothUpdateDTO) {
        return updateFoodBoothBean.exec(requestFoodBoothUpdateDTO);
    }

    // 푸드트럭 운영 중 여부 수정
    public ResponseFoodBoothOpenUpdateDTO updateFoodBoothOpen(RequestFoodBoothOpenUpdateDTO requestFoodBoothOpenUpdateDTO) {
        return updateFoodBoothOpenBean.exec(requestFoodBoothOpenUpdateDTO);
    }

    // 푸드트럭 조회
    public ResponseFoodBoothGetDTO getFoodBooth(UUID boothId) {
        return getFoodBoothBean.exec(boothId);
    }

    // 푸드트럭 전체조회
    public List<ResponseFoodBoothsGetDTO> getFoodBoothAll() {
        return getFoodBoothsBean.exec();
    }
}
