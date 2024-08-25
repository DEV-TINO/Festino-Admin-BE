package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetOrderFinishDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;

    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;
    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;
    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;
    GameOrderRepositoryJPA gameOrderRepositoryJPA;
    MachineOrderRepositoryJPA machineOrderRepositoryJPA;
    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;
    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;

    @Autowired
    public GetOrderFinishDAOBean(OrderRepositoryJPA orderRepositoryJPA, ComputerOrderRepositoryJPA computerOrderRepositoryJPA, ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA, EnergyOrderRepositoryJPA energyOrderRepositoryJPA, GameOrderRepositoryJPA gameOrderRepositoryJPA, MachineOrderRepositoryJPA machineOrderRepositoryJPA, NanoOrderRepositoryJPA nanoOrderRepositoryJPA, NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
    }

    // 해당 boothId, 날짜의 조리완료 상태인 Order 오래된순 전체 조회
    public List<OrderDTO> exec(String adminName, Integer date){

        List<OrderDTO> orderDTOList = new ArrayList<>();

        switch (adminName) {
            // 컴퓨터공학부에서 조회
            case "computer" :
                List<ComputerOrderDAO> computerOrderDAOList = computerOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(computerOrderDAOList.isEmpty()) return new ArrayList<>();

                for(ComputerOrderDAO computerOrderDAO : computerOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromComputerOrderDAO(computerOrderDAO));
                }
                break;

            // 전자공학부에서 조회
            case "electronics" :
                List<ElectronicsOrderDAO> electronicsOrderDAOList = electronicsOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(electronicsOrderDAOList.isEmpty()) return new ArrayList<>();

                for(ElectronicsOrderDAO electronicsOrderDAO : electronicsOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromElectronicsOrderDAO(electronicsOrderDAO));
                }
                break;

            // 에너지전기공학과에서 조회
            case "energy" :
                List<EnergyOrderDAO> energyOrderDAOList = energyOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(energyOrderDAOList.isEmpty()) return new ArrayList<>();

                for(EnergyOrderDAO energyOrderDAO : energyOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromEnergyOrderDAO(energyOrderDAO));
                }
                break;

            // 게임공학과에서 조회
            case "game" :
                List<GameOrderDAO> gameOrderDAOList = gameOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(gameOrderDAOList.isEmpty()) return new ArrayList<>();

                for(GameOrderDAO gameOrderDAO : gameOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromGameOrderDAO(gameOrderDAO));
                }
                break;

            // 기계공학과에서 조회
            case "machine" :
                List<MachineOrderDAO> machineOrderDAOList = machineOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(machineOrderDAOList.isEmpty()) return new ArrayList<>();

                for(MachineOrderDAO machineOrderDAO : machineOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromMachineOrderDAO(machineOrderDAO));
                }
                break;

            // 나노반도체공학과에서 조회
            case "nano" :
                List<NanoOrderDAO> nanoOrderDAOList = nanoOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(nanoOrderDAOList.isEmpty()) return new ArrayList<>();

                for(NanoOrderDAO nanoOrderDAO : nanoOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromNanoOrderDAO(nanoOrderDAO));
                }
                break;

            // 신소재공학과에서 조회
            case "newMaterial" :
                List<NewMaterialOrderDAO> newMaterialOrderDAOList = newMaterialOrderRepositoryJPA.findByOrderTypeAndDateOrderByCreateAtAsc(OrderType.FINISH, date);
                if(newMaterialOrderDAOList.isEmpty()) return new ArrayList<>();

                for(NewMaterialOrderDAO newMaterialOrderDAO : newMaterialOrderDAOList) {
                    orderDTOList.add(OrderDTO.fromNewMaterialOrderDAO(newMaterialOrderDAO));
                }
                break;

            default:
                return null;
        }
        return orderDTOList;
    }

}
