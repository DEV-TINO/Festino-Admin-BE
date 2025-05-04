package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractCookDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.NewMaterialCookDAO;
import com.DevTino.festino_admin.order.repository.jpa.NewMaterialCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("newMaterialCook")
public class NewMaterialCookRepositoryImpl implements CookRepository{

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
    public AbstractCookDAO findById(UUID cookId){

        return newMaterialCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<AbstractCookDAO> findAllByOrderId(UUID orderId){

        // List 요소들을 업캐스팅해 반환
        return newMaterialCookRepositoryJPA.findAllByOrderId(orderId)
                .stream()
                .map(e -> (AbstractCookDAO) e)
                .collect(Collectors.toList());

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<AbstractCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        // List 요소들을 업캐스팅해 반환
        return newMaterialCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date)
                .stream()
                .map(e -> (AbstractCookDAO) e)
                .collect(Collectors.toList());

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<AbstractCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        // List 요소들을 업캐스팅해 반환
        return newMaterialCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService)
                .stream()
                .map(e -> (AbstractCookDAO) e)
                .collect(Collectors.toList());

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<AbstractCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        // List 요소들을 업캐스팅해 반환
        return newMaterialCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish)
                .stream()
                .map(e -> (AbstractCookDAO) e)
                .collect(Collectors.toList());

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<NewMaterialCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(NewMaterialCookDAO.fromCookDTO(cookDTO)); }
        newMaterialCookRepositoryJPA.deleteAll(daoList);

    }

}
