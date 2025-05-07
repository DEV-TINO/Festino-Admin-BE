package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.NanoOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.NanoOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("nano")
public class NanoOrderRepositoryImpl implements OrderRepository<NanoOrderDAO>{

    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;

    public NanoOrderRepositoryImpl(NanoOrderRepositoryJPA nanoOrderRepositoryJPA){
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
    }



    // DTO 받아서 NanoOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        nanoOrderRepositoryJPA.save(NanoOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public NanoOrderDAO findByOrderId(UUID orderId){

        return nanoOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<NanoOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return nanoOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<NanoOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return nanoOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<NanoOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return nanoOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);
    }

}
