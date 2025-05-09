package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.ElectronicsOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.ElectronicsOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("electronics")
public class ElectronicsOrderRepositoryImpl implements OrderRepository<ElectronicsOrderDAO>{

    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;

    public ElectronicsOrderRepositoryImpl(ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA){
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
    }



    // DTO 받아서 ElectronicsOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        electronicsOrderRepositoryJPA.save(ElectronicsOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public ElectronicsOrderDAO findByOrderId(UUID orderId){

        return electronicsOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<ElectronicsOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return electronicsOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<ElectronicsOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return electronicsOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<ElectronicsOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return electronicsOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

    // tableNum, 주문 오래된순 검색
    public List<ElectronicsOrderDAO> findByTableNumOrderByCreateAtAsc(Integer tableNum){

        return electronicsOrderRepositoryJPA.findByTableNumOrderByCreateAtAsc(tableNum);
    }

}
