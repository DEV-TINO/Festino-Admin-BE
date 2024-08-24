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

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromComputerOrderDAO(computerOrderDAO);

            case "electronics" :
                ElectronicsOrderDAO electronicsOrderDAO = electronicsOrderRepositoryJPA.findByOrderId(orderId);

                return OrderDTO.fromElectronicsOrderDAO(electronicsOrderDAO);

            case "energy" :
                EnergyOrderDAO energyOrderDAO = energyOrderRepositoryJPA.findByOrderId(orderId);

                return OrderDTO.fromEnergyOrderDAO(energyOrderDAO);

            case "game" :
                GameOrderDAO gameOrderDAO = gameOrderRepositoryJPA.findByOrderId(orderId);

                return OrderDTO.fromGameOrderDAO(gameOrderDAO);

            case "machine" :
                MachineOrderDAO machineOrderDAO = machineOrderRepositoryJPA.findByOrderId(orderId);

                return OrderDTO.fromMachineOrderDAO(machineOrderDAO);

            case "nano" :
                NanoOrderDAO nanoOrderDAO = nanoOrderRepositoryJPA.findByOrderId(orderId);

                return OrderDTO.fromNanoOrderDAO(nanoOrderDAO);

            case "newMaterial" :
                NewMaterialOrderDAO newMaterialOrderDAO = newMaterialOrderRepositoryJPA.findByOrderId(orderId);

                return  OrderDTO.fromNewMaterialOrderDAO(newMaterialOrderDAO);
                
            default:
                return null;
        }
    }

}
