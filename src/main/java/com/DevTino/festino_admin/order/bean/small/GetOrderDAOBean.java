package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetOrderDAOBean {

    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;
    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;
    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;
    GameOrderRepositoryJPA gameOrderRepositoryJPA;
    MachineOrderRepositoryJPA machineOrderRepositoryJPA;
    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;
    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;
    DesignOrderRepositoryJPA designOrderRepositoryJPA;

    @Autowired
    public GetOrderDAOBean(ComputerOrderRepositoryJPA computerOrderRepositoryJPA, ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA, EnergyOrderRepositoryJPA energyOrderRepositoryJPA, GameOrderRepositoryJPA gameOrderRepositoryJPA, MachineOrderRepositoryJPA machineOrderRepositoryJPA, NanoOrderRepositoryJPA nanoOrderRepositoryJPA, NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA, DesignOrderRepositoryJPA designOrderRepositoryJPA) {
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
        this.designOrderRepositoryJPA = designOrderRepositoryJPA;
    }

    // 학과로 구분해 orderId로 DAO 찾아서 반환
    public OrderDTO exec(String adminName, UUID orderId){
        switch (adminName) {
            // 컴퓨터 공학과
            case "computer" :
                // orderId로 해당 Order DAO 찾고
                ComputerOrderDAO computerOrderDAO = computerOrderRepositoryJPA.findByOrderId(orderId);
                if(computerOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromComputerOrderDAO(computerOrderDAO);

            // 전자공학부
            case "electronics" :
                // orderId로 해당 Order DAO 찾고
                ElectronicsOrderDAO electronicsOrderDAO = electronicsOrderRepositoryJPA.findByOrderId(orderId);
                if(electronicsOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromElectronicsOrderDAO(electronicsOrderDAO);

            // 에너지전기공학과
            case "energy" :
                // orderId로 해당 Order DAO 찾고
                EnergyOrderDAO energyOrderDAO = energyOrderRepositoryJPA.findByOrderId(orderId);
                if(energyOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromEnergyOrderDAO(energyOrderDAO);

            // 게임공학과
            case "game" :
                // orderId로 해당 Order DAO 찾고
                GameOrderDAO gameOrderDAO = gameOrderRepositoryJPA.findByOrderId(orderId);
                if(gameOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromGameOrderDAO(gameOrderDAO);

            // 기계공학과
            case "machine" :
                // orderId로 해당 Order DAO 찾고
                MachineOrderDAO machineOrderDAO = machineOrderRepositoryJPA.findByOrderId(orderId);
                if(machineOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromMachineOrderDAO(machineOrderDAO);

            // 나노반도체공학과
            case "nano" :
                // orderId로 해당 Order DAO 찾고
                NanoOrderDAO nanoOrderDAO = nanoOrderRepositoryJPA.findByOrderId(orderId);
                if(nanoOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return OrderDTO.fromNanoOrderDAO(nanoOrderDAO);

            // 신소재공학과
            case "newMaterial" :
                // orderId로 해당 Order DAO 찾고
                NewMaterialOrderDAO newMaterialOrderDAO = newMaterialOrderRepositoryJPA.findByOrderId(orderId);
                if(newMaterialOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return  OrderDTO.fromNewMaterialOrderDAO(newMaterialOrderDAO);

            // 디자인공학부
            case "design" :
                // orderId로 해당 Order DAO 찾고
                DesignOrderDAO designOrderDAO = designOrderRepositoryJPA.findByOrderId(orderId);
                if(designOrderDAO == null) return null;

                // OrderDTO 타입으로 변경후 반환
                return  OrderDTO.fromDesignOrderDAO(designOrderDAO);
                
            default:
                return null;
        }
    }

}
