package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateFoodBoothDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetFoodBoothBean {
    GetFoodBoothDAOBean getFoodBoothDAOBean;
    CreateFoodBoothDTOBean createFoodBoothDTOBean;

    @Autowired
    public GetFoodBoothBean(GetFoodBoothDAOBean getFoodBoothDAOBean, CreateFoodBoothDTOBean createFoodBoothDTOBean) {
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
        this.createFoodBoothDTOBean = createFoodBoothDTOBean;
    }

    public ResponseFoodBoothGetDTO exec(UUID boothId) {

        // 부스아이디를 통해 원하는 객체(DAO) 찾기
        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(boothId);
        if(foodBoothDAO == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        // DTO 생성해서 반환
        return createFoodBoothDTOBean.exec(foodBoothDAO);
    }
}
