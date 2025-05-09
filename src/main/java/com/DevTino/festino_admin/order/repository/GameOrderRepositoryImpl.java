package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.GameOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.GameOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("game")
public class GameOrderRepositoryImpl implements OrderRepository<GameOrderDAO>{

    GameOrderRepositoryJPA gameOrderRepositoryJPA;

    public GameOrderRepositoryImpl(GameOrderRepositoryJPA gameOrderRepositoryJPA){
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
    }



    // DTO 받아서 GameOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        gameOrderRepositoryJPA.save(GameOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public GameOrderDAO findByOrderId(UUID orderId){

        return gameOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<GameOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return gameOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<GameOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return gameOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<GameOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return gameOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

    // tableNum, 주문 오래된순 검색
    public List<GameOrderDAO> findByTableNumOrderByCreateAtAsc(Integer tableNum){

        return gameOrderRepositoryJPA.findByTableNumOrderByCreateAtAsc(tableNum);
    }

}
