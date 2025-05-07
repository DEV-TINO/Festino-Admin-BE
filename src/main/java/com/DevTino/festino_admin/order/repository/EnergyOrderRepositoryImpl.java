package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.EnergyOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.EnergyOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("energy")
public class EnergyOrderRepositoryImpl implements OrderRepository<EnergyOrderDAO>{

    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;

    public EnergyOrderRepositoryImpl(EnergyOrderRepositoryJPA energyOrderRepositoryJPA){
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
    }



    // DTO 받아서 EnergyOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        energyOrderRepositoryJPA.save(EnergyOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public EnergyOrderDAO findByOrderId(UUID orderId){

        return energyOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<EnergyOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return energyOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<EnergyOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return energyOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<EnergyOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return energyOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

}
