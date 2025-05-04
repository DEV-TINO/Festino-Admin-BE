package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractCookDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;

import java.util.List;
import java.util.UUID;

public interface CookRepository {

    // DTO 받아서 DAO로 변환해 저장
    public void save(CookDTO cookDTO);
    
    // DTO 리스트 받아서 DAO 리스트로 변환해 저장
    public void saveAll(List<CookDTO> dtoList);

    // cookId로 Cook 검색
    public AbstractCookDAO findById(UUID cookId);

    // orderId에 해당하는 Cook 검색
    public List<AbstractCookDAO> findAllByOrderId(UUID orderId);

    // menuId, isFinish, date에 해당하는 Cook 오래된순 검색
    public List<AbstractCookDAO> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);

    // menuId, date, isFinish에 해당하는 Cook 검색
    public List<AbstractCookDAO> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);

    // isService 신경 쓰지 않고 menuId, date, isFinish에 해당하는 cook 검색
    public List<AbstractCookDAO> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish);
    
    // DTO 리스트 받아서 DAO 리스트로 변환해 삭제
    public void deleteAll(List<CookDTO> dtoList);

}
