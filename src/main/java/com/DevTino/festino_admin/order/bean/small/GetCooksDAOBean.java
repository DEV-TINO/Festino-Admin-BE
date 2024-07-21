package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.repository.CookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCooksDAOBean {

    CookRepositoryJPA cookRepositoryJPA;

    @Autowired
    public GetCooksDAOBean(CookRepositoryJPA cookRepositoryJPA){
        this.cookRepositoryJPA = cookRepositoryJPA;
    }



    // orderId에 해당하는 Cook 찾아서 List로 반환
    public List<CookDAO> exec(UUID orderId){

        return cookRepositoryJPA.findAllByOrderId(orderId);

    }



    // menuName, isFinish, date로 Cook 최신순 전체 조회
    public List<CookDAO> exec(String menuName, Boolean isFinish, Integer date){

        return cookRepositoryJPA.findByMenuNameAndIsFinishAndDateOrderByCreateAtDesc(menuName, isFinish, date);

    }



    // menuName, date로 Cook 전체 조회
    public List<CookDAO> exec(String menuName, Integer date){

        return cookRepositoryJPA.findByMenuNameAndDate(menuName, date);

    }

}
