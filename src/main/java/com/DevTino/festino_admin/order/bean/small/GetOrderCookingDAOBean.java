package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.ComputerOrderDAO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.GameOrderDAO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetOrderCookingDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;
    GameOrderRepositoryJPA gameOrderRepositoryJPA;
    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;
    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;
    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;
    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;
    MachineOrderRepositoryJPA machineOrderRepositoryJPA;

    @Autowired
    public GetOrderCookingDAOBean(OrderRepositoryJPA orderRepositoryJPA, ComputerOrderRepositoryJPA computerOrderRepositoryJPA, GameOrderRepositoryJPA gameOrderRepositoryJPA, ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA, EnergyOrderRepositoryJPA energyOrderRepositoryJPA, NanoOrderRepositoryJPA nanoOrderRepositoryJPA, NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA, MachineOrderRepositoryJPA machineOrderRepositoryJPA) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
    }

    // 날짜의 조리중인 Order 오래된순 전체 조회
    public List<OrderDTO> exec(String adminName, Integer date){
        List<OrderDTO> orderDTOList = new ArrayList<>();

//        return orderRepositoryJPA.findByBoothIdAndIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(boothId, true, OrderType.COOKING, date);
        switch (adminName) {
            case "computer" :
                List<ComputerOrderDAO> computerOrderDAOList = computerOrderRepositoryJPA.findByIsDepositAndOrderTypeAndDateOrderByCreateAtAsc(true, OrderType.COOKING, date);
                for(ComputerOrderDAO computerOrderDAO : computerOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromComputerOrderDAO(computerOrderDAO));
                }
                break;
            default :
                return null;
        }
        return orderDTOList;
    }
}
