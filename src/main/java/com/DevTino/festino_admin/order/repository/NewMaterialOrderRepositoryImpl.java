package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.NewMaterialOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.NewMaterialOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("newMaterial")
public class NewMaterialOrderRepositoryImpl implements OrderRepository<NewMaterialOrderDAO>{

    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;

    public NewMaterialOrderRepositoryImpl(NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA){
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
    }



    // DTO 받아서 NewMaterialOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        newMaterialOrderRepositoryJPA.save(NewMaterialOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public NewMaterialOrderDAO findByOrderId(UUID orderId){

        return newMaterialOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<NewMaterialOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return newMaterialOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<NewMaterialOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return newMaterialOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<NewMaterialOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return newMaterialOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

}
