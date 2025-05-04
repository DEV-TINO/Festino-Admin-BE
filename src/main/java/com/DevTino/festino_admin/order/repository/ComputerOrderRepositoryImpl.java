package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.ComputerOrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("computer")
public class ComputerOrderRepositoryImpl implements OrderRepository{

    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;

    @Autowired
    public ComputerOrderRepositoryImpl(ComputerOrderRepositoryJPA computerOrderRepositoryJPA){
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
    }



    // DTO 받아서 ComputerOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        computerOrderRepositoryJPA.save(ComputerOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public AbstractOrderDAO findByOrderId(UUID orderId){

        return computerOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<AbstractOrderDAO> findByDateOrderByCreateAtAsc(Integer date){
        
        // List 요소들을 업캐스팅해 반환
        return computerOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // OrderType으로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return computerOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return computerOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

}
