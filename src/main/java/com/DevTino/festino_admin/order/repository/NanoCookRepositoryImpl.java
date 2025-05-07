package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.NanoCookDAO;
import com.DevTino.festino_admin.order.repository.jpa.NanoCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("nanoCook")
public class NanoCookRepositoryImpl implements CookRepository<NanoCookDAO>{

    NanoCookRepositoryJPA nanoCookRepositoryJPA;

    @Autowired
    public NanoCookRepositoryImpl(NanoCookRepositoryJPA nanoCookRepositoryJPA){
        this.nanoCookRepositoryJPA = nanoCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        nanoCookRepositoryJPA.save(NanoCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<NanoCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(NanoCookDAO.fromCookDTO(cookDTO)); }
        nanoCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public NanoCookDAO findById(UUID cookId){

        return nanoCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<NanoCookDAO> findAllByOrderId(UUID orderId){

        return nanoCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<NanoCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return nanoCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<NanoCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return nanoCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<NanoCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return nanoCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<NanoCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(NanoCookDAO.fromCookDTO(cookDTO)); }
        nanoCookRepositoryJPA.deleteAll(daoList);

    }

}
