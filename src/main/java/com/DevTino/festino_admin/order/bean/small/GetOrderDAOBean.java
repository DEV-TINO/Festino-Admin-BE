package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetOrderDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;
    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;
    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;
    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;
    GameOrderRepositoryJPA gameOrderRepositoryJPA;
    MachineOrderRepositoryJPA machineOrderRepositoryJPA;
    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;
    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;

    @Autowired
    public GetOrderDAOBean(OrderRepositoryJPA orderRepositoryJPA, ComputerOrderRepositoryJPA computerOrderRepositoryJPA, ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA, EnergyOrderRepositoryJPA energyOrderRepositoryJPA, GameOrderRepositoryJPA gameOrderRepositoryJPA, MachineOrderRepositoryJPA machineOrderRepositoryJPA, NanoOrderRepositoryJPA nanoOrderRepositoryJPA, NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
    }

    // orderId로 DAO 찾아서 반환하는 메서드
    public OrderDAO exec(UUID orderId){

        return orderRepositoryJPA.findByOrderId(orderId);

    }

    // 학과로 구분해 orderId로 DAO 찾아서 반환
    public OrderDTO exec(UUID orderId, String adminName){
        switch (adminName) {
            // 컴퓨터 공학과
            case "computer" :
                // orderId로 해당 Order DAO 찾고
                ComputerOrderDAO computerOrderDAO = computerOrderRepositoryJPA.findByOrderId(orderId);
                if(computerOrderDAO == null) return null;

                //orderType 값을 CANCEL로 변경
                computerOrderDAO.setOrderType(OrderType.CANCEL);

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromComputerOrderDAO(computerOrderDAO);

            case "electronics" :
                ElectronicsOrderDAO electronicsOrderDAO = electronicsOrderRepositoryJPA.findByOrderId(orderId);
                if(electronicsOrderDAO == null) return null;

                electronicsOrderDAO.setOrderType(OrderType.CANCEL);
                return OrderDTO.fromElectronicsOrderDAO(electronicsOrderDAO);

            case "energy" :
                EnergyOrderDAO energyOrderDAO = energyOrderRepositoryJPA.findByOrderId(orderId);
                if(energyOrderDAO == null) return null;

                energyOrderDAO.setOrderType(OrderType.CANCEL);
                return OrderDTO.fromEnergyOrderDAO(energyOrderDAO);

            case "game" :
                GameOrderDAO gameOrderDAO = gameOrderRepositoryJPA.findByOrderId(orderId);
                if(gameOrderDAO == null) return null;

                gameOrderDAO.setOrderType(OrderType.CANCEL);
                return OrderDTO.fromGameOrderDAO(gameOrderDAO);

            case "machine" :
                MachineOrderDAO machineOrderDAO = machineOrderRepositoryJPA.findByOrderId(orderId);
                if(machineOrderDAO == null) return null;

                machineOrderDAO.setOrderType(OrderType.CANCEL);
                return OrderDTO.fromMachineOrderDAO(machineOrderDAO);

            case "nano" :
                NanoOrderDAO nanoOrderDAO = nanoOrderRepositoryJPA.findByOrderId(orderId);
                if(nanoOrderDAO == null) return null;

                nanoOrderDAO.setOrderType(OrderType.CANCEL);
                return OrderDTO.fromNanoOrderDAO(nanoOrderDAO);

            default:
                return null;
        }
    }

}
