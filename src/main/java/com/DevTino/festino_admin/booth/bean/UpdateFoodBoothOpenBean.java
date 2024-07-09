package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateFoodBoothOpenDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateFoodBoothOpenBean {
    GetFoodBoothDAOBean getFoodBoothDAOBean;
    SaveFoodBoothDAOBean saveFoodBoothDAOBean;
    CreateFoodBoothOpenDTOBean createFoodBoothOpenDTOBean;

    @Autowired
    public UpdateFoodBoothOpenBean(GetFoodBoothDAOBean getFoodBoothDAOBean, SaveFoodBoothDAOBean saveFoodBoothDAOBean, CreateFoodBoothOpenDTOBean createFoodBoothOpenDTOBean) {
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
        this.saveFoodBoothDAOBean = saveFoodBoothDAOBean;
        this.createFoodBoothOpenDTOBean = createFoodBoothOpenDTOBean;
    }

    // 푸드트럭 운영 중 여부 수정
    public ResponseFoodBoothOpenUpdateDTO exec(RequestFoodBoothOpenUpdateDTO requestFoodBoothOpenUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(requestFoodBoothOpenUpdateDTO.getBoothId());
        if(foodBoothDAO == null) return null;

        // DAO 운영 중 여부 수정
        if(requestFoodBoothOpenUpdateDTO.getIsOpen() == foodBoothDAO.getIsOpen())
            foodBoothDAO.setIsOpen(!foodBoothDAO.getIsOpen());
        else
            return null;

        // 수정된 DAO 저장
        saveFoodBoothDAOBean.exec(foodBoothDAO);

        // DTO 생성해서 반환
        return createFoodBoothOpenDTOBean.exec(foodBoothDAO);
    }
}
