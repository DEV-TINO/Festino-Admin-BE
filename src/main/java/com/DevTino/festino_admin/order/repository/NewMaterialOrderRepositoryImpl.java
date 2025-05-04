package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.NewMaterialOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.NewMaterialOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("newMaterial")
public class NewMaterialOrderRepositoryImpl implements OrderRepository{

    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;

    public NewMaterialOrderRepositoryImpl(NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA){
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
    }



    // DTO 받아서 NewMaterialOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        newMaterialOrderRepositoryJPA.save(NewMaterialOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public AbstractOrderDAO findByOrderId(UUID orderId){

        return newMaterialOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<AbstractOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        // List 요소들을 업캐스팅해 반환
        return newMaterialOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // OrderType으로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return newMaterialOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return newMaterialOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

}
