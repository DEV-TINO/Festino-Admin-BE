package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.NewMaterialCookDAO;
import com.DevTino.festino_admin.order.repository.jpa.NewMaterialCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("newMaterialCook")
public class NewMaterialCookRepositoryImpl implements CookRepository<NewMaterialCookDAO>{

    NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA;

    @Autowired
    public NewMaterialCookRepositoryImpl(NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA){
        this.newMaterialCookRepositoryJPA = newMaterialCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        newMaterialCookRepositoryJPA.save(NewMaterialCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<NewMaterialCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(NewMaterialCookDAO.fromCookDTO(cookDTO)); }
        newMaterialCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public NewMaterialCookDAO findById(UUID cookId){

        return newMaterialCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<NewMaterialCookDAO> findAllByOrderId(UUID orderId){

        return newMaterialCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<NewMaterialCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return newMaterialCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<NewMaterialCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return newMaterialCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<NewMaterialCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return newMaterialCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<NewMaterialCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(NewMaterialCookDAO.fromCookDTO(cookDTO)); }
        newMaterialCookRepositoryJPA.deleteAll(daoList);

    }

}
