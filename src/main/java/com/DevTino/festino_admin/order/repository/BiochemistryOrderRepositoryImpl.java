package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.BiochemistryOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.BiochemistryOrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component("biochemistry")
public class BiochemistryOrderRepositoryImpl implements OrderRepository<BiochemistryOrderDAO>{

    BiochemistryOrderRepositoryJPA biochemistryOrderRepositoryJPA;

    @Autowired
    public BiochemistryOrderRepositoryImpl(BiochemistryOrderRepositoryJPA biochemistryOrderRepositoryJPA){
        this.biochemistryOrderRepositoryJPA = biochemistryOrderRepositoryJPA;
    }



    // DTO 받아서 ComputerOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        biochemistryOrderRepositoryJPA.save(BiochemistryOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public BiochemistryOrderDAO findByOrderId(UUID orderId){

        return biochemistryOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<BiochemistryOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return biochemistryOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<BiochemistryOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return biochemistryOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<BiochemistryOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return biochemistryOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

    // tableNum, 주문 오래된순 검색
    public List<BiochemistryOrderDAO> findByTableNumOrderByCreateAtAsc(Integer tableNum){

        return biochemistryOrderRepositoryJPA.findByTableNumOrderByCreateAtAsc(tableNum);
    }

    // 테이블 번호에 따른 주문 검색
    public List<BiochemistryOrderDAO> findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(Integer date, LocalDateTime after){

        return biochemistryOrderRepositoryJPA.findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(date, after);
    }

}
