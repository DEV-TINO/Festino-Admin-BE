package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.repository.CookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveCookDAOBean {

    CookRepositoryJPA cookRepositoryJPA;

    @Autowired
    public SaveCookDAOBean(CookRepositoryJPA cookRepositoryJPA){
        this.cookRepositoryJPA = cookRepositoryJPA;
    }



    // 조리 DAO를 DB에 저장
    public void exec(CookDAO cookDAO){

        cookRepositoryJPA.save(cookDAO);

    }

    // 조리 DAO 리스트를 DB에 저장
    public void exec(List<CookDAO> cookDAOList){

        cookRepositoryJPA.saveAll(cookDAOList);

    }

}
