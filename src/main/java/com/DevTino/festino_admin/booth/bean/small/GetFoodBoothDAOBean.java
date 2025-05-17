package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import com.DevTino.festino_admin.booth.repository.FoodBoothRepositoryJPA;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetFoodBoothDAOBean {
    FoodBoothRepositoryJPA foodBoothRepository;

    @Autowired
    public GetFoodBoothDAOBean(FoodBoothRepositoryJPA foodBoothRepository) {
        this.foodBoothRepository = foodBoothRepository;
    }

    // 부스 아이디로 DAO 찾아서 반환
    public FoodBoothDAO exec(UUID boothId) {

        FoodBoothDAO dao = foodBoothRepository.findById(boothId).orElse(null);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // 전체 DAO 반환
    public List<FoodBoothDAO> exec() {

        List<FoodBoothDAO> daoList = foodBoothRepository.findAll();
        if(daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;

    }

    // adminName으로 DAO 찾아서 반환
    public FoodBoothDAO exec(String adminName) { return foodBoothRepository.findByAdminName(adminName); }
}
