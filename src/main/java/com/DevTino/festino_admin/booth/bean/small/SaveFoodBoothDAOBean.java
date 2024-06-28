package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import com.DevTino.festino_admin.booth.repository.FoodBoothRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveFoodBoothDAOBean {
    FoodBoothRepositoryJPA foodBoothRepository;

    @Autowired
    public SaveFoodBoothDAOBean(FoodBoothRepositoryJPA foodBoothRepository) {
        this.foodBoothRepository = foodBoothRepository;
    }

    // 푸드트럭 DAO를 DB에 저장
    public void exec(FoodBoothDAO foodBoothDAO) {
        foodBoothRepository.save(foodBoothDAO);
    }
}
