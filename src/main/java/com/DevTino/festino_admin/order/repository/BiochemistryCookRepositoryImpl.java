package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.BiochemistryCookDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.repository.jpa.BiochemistryCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("biochemistryCook")
public class BiochemistryCookRepositoryImpl implements CookRepository<BiochemistryCookDAO>{

    BiochemistryCookRepositoryJPA biochemistryCookRepositoryJPA;

    @Autowired
    public BiochemistryCookRepositoryImpl(BiochemistryCookRepositoryJPA biochemistryCookRepositoryJPA){
        this.biochemistryCookRepositoryJPA = biochemistryCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        biochemistryCookRepositoryJPA.save(BiochemistryCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<BiochemistryCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(BiochemistryCookDAO.fromCookDTO(cookDTO)); }
        biochemistryCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public BiochemistryCookDAO findById(UUID cookId){

        return biochemistryCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<BiochemistryCookDAO> findAllByOrderId(UUID orderId){

        return biochemistryCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<BiochemistryCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return biochemistryCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<BiochemistryCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return biochemistryCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<BiochemistryCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return biochemistryCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<BiochemistryCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(BiochemistryCookDAO.fromCookDTO(cookDTO)); }
        biochemistryCookRepositoryJPA.deleteAll(daoList);

    }

}
