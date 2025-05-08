package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.EnergyCookDAO;
import com.DevTino.festino_admin.order.repository.jpa.EnergyCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("energyCook")
public class EnergyCookRepositoryImpl implements CookRepository<EnergyCookDAO>{

    EnergyCookRepositoryJPA energyCookRepositoryJPA;

    @Autowired
    public EnergyCookRepositoryImpl(EnergyCookRepositoryJPA energyCookRepositoryJPA){
        this.energyCookRepositoryJPA = energyCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        energyCookRepositoryJPA.save(EnergyCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<EnergyCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(EnergyCookDAO.fromCookDTO(cookDTO)); }
        energyCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public EnergyCookDAO findById(UUID cookId){

        return energyCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<EnergyCookDAO> findAllByOrderId(UUID orderId){

        return energyCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<EnergyCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return energyCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<EnergyCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return energyCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<EnergyCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return energyCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<EnergyCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(EnergyCookDAO.fromCookDTO(cookDTO)); }
        energyCookRepositoryJPA.deleteAll(daoList);

    }

}
