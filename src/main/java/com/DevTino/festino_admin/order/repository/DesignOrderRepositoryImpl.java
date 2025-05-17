package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DesignOrderDAO;
import com.DevTino.festino_admin.order.domain.NanoOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.DesignOrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component("design")
public class DesignOrderRepositoryImpl implements OrderRepository<DesignOrderDAO>{

    DesignOrderRepositoryJPA designOrderRepositoryJPA;

    @Autowired
    public DesignOrderRepositoryImpl(DesignOrderRepositoryJPA designOrderRepositoryJPA){
        this.designOrderRepositoryJPA = designOrderRepositoryJPA;
    }



    // DTO 받아서 DesignOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        designOrderRepositoryJPA.save(DesignOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public DesignOrderDAO findByOrderId(UUID orderId){

        return designOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<DesignOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return designOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<DesignOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return designOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<DesignOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return designOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

    // tableNum, 주문 오래된순 검색
    public List<DesignOrderDAO> findByTableNumOrderByCreateAtAsc(Integer tableNum){

        return designOrderRepositoryJPA.findByTableNumOrderByCreateAtAsc(tableNum);
    }

    // 테이블 번호에 따른 주문 검색
    public List<DesignOrderDAO> findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(Integer date, LocalDateTime after){

        return designOrderRepositoryJPA.findByDateAndCreateAtAfterOrderByTableNumAscCreateAtAsc(date, after);
    }

}
