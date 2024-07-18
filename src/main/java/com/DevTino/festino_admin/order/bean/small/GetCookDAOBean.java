package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.repository.CookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCookDAOBean {

    CookRepositoryJPA cookRepositoryJPA;

    @Autowired
    public GetCookDAOBean(CookRepositoryJPA cookRepositoryJPA){
        this.cookRepositoryJPA = cookRepositoryJPA;
    }



    // cookId로 DAO 찾아서 반환하는 메서드
    public CookDAO exec(UUID cookId){

        return cookRepositoryJPA.findById(cookId).orElse(null);

    }

}
