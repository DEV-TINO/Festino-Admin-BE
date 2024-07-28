package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.repository.CookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteCooksDAOBean {

    CookRepositoryJPA cookRepositoryJPA;

    @Autowired
    public DeleteCooksDAOBean(CookRepositoryJPA cookRepositoryJPA){
        this.cookRepositoryJPA = cookRepositoryJPA;
    }



    // CookDAO 리스트를 삭제
    public void exec(List<CookDAO> cookDAOList){

        cookRepositoryJPA.deleteAll(cookDAOList);

    }

}
