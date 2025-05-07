package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DesignCookDAO;
import com.DevTino.festino_admin.order.repository.jpa.DesignCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("designCook")
public class DesignCookRepositoryImpl implements CookRepository<DesignCookDAO>{

    DesignCookRepositoryJPA designCookRepositoryJPA;

    @Autowired
    public DesignCookRepositoryImpl(DesignCookRepositoryJPA designCookRepositoryJPA){
        this.designCookRepositoryJPA = designCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        designCookRepositoryJPA.save(DesignCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<DesignCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(DesignCookDAO.fromCookDTO(cookDTO)); }
        designCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public DesignCookDAO findById(UUID cookId){

        return designCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<DesignCookDAO> findAllByOrderId(UUID orderId){

        return designCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<DesignCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return designCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<DesignCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return designCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<DesignCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return designCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<DesignCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(DesignCookDAO.fromCookDTO(cookDTO)); }
        designCookRepositoryJPA.deleteAll(daoList);

    }

}
