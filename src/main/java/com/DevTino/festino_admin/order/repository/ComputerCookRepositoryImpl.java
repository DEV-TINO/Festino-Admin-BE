package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.ComputerCookDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.repository.jpa.ComputerCookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("computerCook")
public class ComputerCookRepositoryImpl implements CookRepository<ComputerCookDAO>{

    ComputerCookRepositoryJPA computerCookRepositoryJPA;

    @Autowired
    public ComputerCookRepositoryImpl(ComputerCookRepositoryJPA computerCookRepositoryJPA){
        this.computerCookRepositoryJPA = computerCookRepositoryJPA;
    }



    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO){

        computerCookRepositoryJPA.save(ComputerCookDAO.fromCookDTO(cookDTO));

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList){

        List<ComputerCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(ComputerCookDAO.fromCookDTO(cookDTO)); }
        computerCookRepositoryJPA.saveAll(daoList);

    }

    // cookId로 Cook 검색
    public ComputerCookDAO findById(UUID cookId){

        return computerCookRepositoryJPA.findById(cookId).orElse(null);

    }

    // orderId에 해당하는 Cook 검색
    public List<ComputerCookDAO> findAllByOrderId(UUID orderId){

        return computerCookRepositoryJPA.findAllByOrderId(orderId);

    }

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<ComputerCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date){

        return computerCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);

    }

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<ComputerCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        return computerCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);

    }

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<ComputerCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish){

        return computerCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);

    }

    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList){

        List<ComputerCookDAO> daoList = new ArrayList<>();
        for (CookDTO cookDTO : dtoList) { daoList.add(ComputerCookDAO.fromCookDTO(cookDTO)); }
        computerCookRepositoryJPA.deleteAll(daoList);

    }

}
