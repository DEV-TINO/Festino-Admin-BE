package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.ElectronicsCookDAO;
import com.DevTino.festino_admin.order.repository.jpa.ElectronicsCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("electronicsCook")
public class ElectronicsCookRepositoryImpl implements CookRepository<ElectronicsCookDAO>{

    ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA;

    @Autowired
    public ElectronicsCookRepositoryImpl(ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA){
        this.electronicsCookRepositoryJPA = electronicsCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        electronicsCookRepositoryJPA.save(ElectronicsCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<ElectronicsCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(ElectronicsCookDAO.fromCookDTO(cookDTO)); }
        electronicsCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public ElectronicsCookDAO findById(UUID cookId){

        return electronicsCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<ElectronicsCookDAO> findAllByOrderId(UUID orderId){

        return electronicsCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<ElectronicsCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return electronicsCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<ElectronicsCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return electronicsCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<ElectronicsCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return electronicsCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<ElectronicsCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(ElectronicsCookDAO.fromCookDTO(cookDTO)); }
        electronicsCookRepositoryJPA.deleteAll(daoList);

    }

}
