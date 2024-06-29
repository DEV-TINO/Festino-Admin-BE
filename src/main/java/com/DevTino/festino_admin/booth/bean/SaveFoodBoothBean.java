package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothSaveDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveFoodBoothBean {
    CreateFoodBoothDAOBean createFoodBoothDAOBean;
    SaveFoodBoothDAOBean saveFoodBoothDAOBean;

    @Autowired
    public SaveFoodBoothBean(CreateFoodBoothDAOBean createFoodBoothDAOBean, SaveFoodBoothDAOBean saveFoodBoothDAOBean) {
        this.createFoodBoothDAOBean = createFoodBoothDAOBean;
        this.saveFoodBoothDAOBean = saveFoodBoothDAOBean;
    }

    // 푸드트럭 등록
    public UUID exec(RequestFoodBoothSaveDTO requestFoodBoothSaveDTO) {

        // 푸드트럭 DAO 생성
        FoodBoothDAO foodBoothDAO = createFoodBoothDAOBean.exec(requestFoodBoothSaveDTO);
        if(foodBoothDAO == null) return null;

        // 푸드트럭 저장
        saveFoodBoothDAOBean.exec(foodBoothDAO);

        // 키값 반환
        return foodBoothDAO.getBoothId();
    }
}
