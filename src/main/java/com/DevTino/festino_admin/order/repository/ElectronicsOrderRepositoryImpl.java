package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.ElectronicsOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.ElectronicsOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("electronics")
public class ElectronicsOrderRepositoryImpl implements OrderRepository{

    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;

    public ElectronicsOrderRepositoryImpl(ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA){
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
    }



    // DTO 받아서 ElectronicsOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        electronicsOrderRepositoryJPA.save(ElectronicsOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public AbstractOrderDAO findByOrderId(UUID orderId){

        return electronicsOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<AbstractOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        // List 요소들을 업캐스팅해 반환
        return electronicsOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // OrderType으로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return electronicsOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return electronicsOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

}
