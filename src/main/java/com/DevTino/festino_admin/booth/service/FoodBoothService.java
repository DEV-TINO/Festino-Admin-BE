package com.DevTino.festino_admin.booth.service;

import com.DevTino.festino_admin.booth.bean.SaveFoodBoothBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FoodBoothService {
    SaveFoodBoothBean saveFoodBoothBean;

    @Autowired
    public FoodBoothService(SaveFoodBoothBean saveFoodBoothBean) {
        this.saveFoodBoothBean = saveFoodBoothBean;
    }

    // 푸드트럭 등록
    public UUID saveFoodBooth(RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {
        return saveFoodBoothBean.exec(requestFoodBoothSaveDTO);
    }
}
