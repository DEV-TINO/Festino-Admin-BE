package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.AbstractOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.GameOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.GameOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("game")
public class GameOrderRepositoryImpl implements OrderRepository{

    GameOrderRepositoryJPA gameOrderRepositoryJPA;

    public GameOrderRepositoryImpl(GameOrderRepositoryJPA gameOrderRepositoryJPA){
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
    }



    // DTO 받아서 GameOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        gameOrderRepositoryJPA.save(GameOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public AbstractOrderDAO findByOrderId(UUID orderId){

        return gameOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<AbstractOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        // List 요소들을 업캐스팅해 반환
        return gameOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // OrderType으로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return gameOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<AbstractOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        // List 요소들을 업캐스팅해 반환
        return gameOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date)
                .stream()
                .map(e -> (AbstractOrderDAO) e)
                .collect(Collectors.toList());

    }

}
