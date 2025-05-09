package com.DevTino.festino_admin.order.repository;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.MachineOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.jpa.MachineOrderRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component("machine")
public class MachineOrderRepositoryImpl implements OrderRepository<MachineOrderDAO>{

    MachineOrderRepositoryJPA machineOrderRepositoryJPA;

    public MachineOrderRepositoryImpl(MachineOrderRepositoryJPA machineOrderRepositoryJPA){
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
    }



    // DTO 받아서 MachineOrderDAO로 변환해 저장
    public void save(OrderDTO orderDTO){

        machineOrderRepositoryJPA.save(MachineOrderDAO.fromOrderDTO(orderDTO));

    }

    // orderId로 주문 검색
    public MachineOrderDAO findByOrderId(UUID orderId){

        return machineOrderRepositoryJPA.findByOrderId(orderId);

    }

    // 날짜의 전체 주문 오래된순 검색
    public List<MachineOrderDAO> findByDateOrderByCreateAtAsc(Integer date){

        return machineOrderRepositoryJPA.findByDateOrderByCreateAtAsc(date);

    }

    // OrderType으로 주문 오래된순 검색
    public List<MachineOrderDAO> findByOrderTypeAndDateOrderByCreateAtAsc(OrderType orderType, Integer date){

        return machineOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(orderType, date);

    }

    // isDeposit, OrderType, date로 주문 오래된순 검색
    public List<MachineOrderDAO> findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(Boolean isDeposit, OrderType orderType, Integer date){

        return machineOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(isDeposit, orderType, date);

    }

    // tableNum, 주문 오래된순 검색
    public List<MachineOrderDAO> findByTableNumOrderByCreateAtAsc(Integer tableNum){

        return machineOrderRepositoryJPA.findByTableNumOrderByCreateAtAsc(tableNum);
    }

}
