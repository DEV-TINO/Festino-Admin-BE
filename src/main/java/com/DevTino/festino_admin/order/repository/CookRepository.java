package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractCookDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;

import java.util.List;
import java.util.UUID;

public interface CookRepository<T extends AbstractCookDAO> {

    public void save(CookDTO cookDTO);
    public void saveAll(List<CookDTO> dtoList);
    public T findById(UUID cookId);
    public List<T> findAllByOrderId(UUID orderId);
    public List<T> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);
    public List<T> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);
    public List<T> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish);
    public void deleteAll(List<CookDTO> dtoList);

}
