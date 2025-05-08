package com.DevTino.festino_admin.order.repository.jpa;

import com.DevTino.festino_admin.order.domain.AbstractCookDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface CookRepositoryJPA<T extends AbstractCookDAO> extends JpaRepository<T, UUID> {

    public List<T> findAllByOrderId(UUID orderId);

    public List<T> findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(UUID menuId, Boolean isFinish, Integer date);

    public List<T> findByMenuIdAndDateAndIsFinishAndIsService(UUID menuId, Integer date, Boolean isFinish, Boolean isService);

    public List<T> findByMenuIdAndDateAndIsFinish(UUID menuId, Integer date, Boolean isFinish);

}
