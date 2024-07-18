package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateFoodBoothsDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothsGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetFoodBoothsBean {
    GetFoodBoothDAOBean getFoodBoothDAOBean;
    CreateFoodBoothsDTOBean createFoodBoothsDTOBean;

    @Autowired
    public GetFoodBoothsBean(GetFoodBoothDAOBean getFoodBoothDAOBean, CreateFoodBoothsDTOBean createFoodBoothsDTOBean) {
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
        this.createFoodBoothsDTOBean = createFoodBoothsDTOBean;
    }

    // 푸드트럭 전체조회
    public List<ResponseFoodBoothsGetDTO> exec() {
        // 푸드트럭 전체 DAO 가져오기
        List<FoodBoothDAO> foodBoothDAOList = getFoodBoothDAOBean.exec();
        if(foodBoothDAOList.isEmpty()) return null;

        // DAO 리스트를 DAO로 바꾸고 반환
        return createFoodBoothsDTOBean.exec(foodBoothDAOList);
    }
}
