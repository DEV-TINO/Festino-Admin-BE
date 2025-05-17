package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.NanoOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.ComputerOrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component("computer")
public class ComputerOrderRepositoryImpl implements OrderRepository<ComputerOrderDAO>{

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
    public ComputerOrderDAO findByOrderId(UUID orderId){

        return computerOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<ComputerOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return computerOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<ComputerOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return computerOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<ComputerOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return computerOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

    // tableNum, 주문 오래된순 검색
    public List<ComputerOrderDAO> findByTableNumOrderByCreateAtAsc(Integer tableNum){

        return computerOrderRepositoryJPA.findByTableNumOrderByCreateAtAsc(tableNum);
    }

    // 테이블 번호에 따른 주문 검색
    public List<ComputerOrderDAO> findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(Integer date, LocalDateTime after){

        return computerOrderRepositoryJPA.findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(date, after);
    }

}
