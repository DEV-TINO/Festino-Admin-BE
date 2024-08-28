package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderDAOBean {

    OrderRepositoryJPA orderRepositoryJPA;
    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;
    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;
    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;
    GameOrderRepositoryJPA gameOrderRepositoryJPA;
    MachineOrderRepositoryJPA machineOrderRepositoryJPA;
    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;
    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;

    @Autowired
    public SaveOrderDAOBean(OrderRepositoryJPA orderRepositoryJPA, ComputerOrderRepositoryJPA computerOrderRepositoryJPA, ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA, EnergyOrderRepositoryJPA energyOrderRepositoryJPA, GameOrderRepositoryJPA gameOrderRepositoryJPA, MachineOrderRepositoryJPA machineOrderRepositoryJPA, NanoOrderRepositoryJPA nanoOrderRepositoryJPA, NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
    }

    // 주문 DAO를 DB에 저장
    public void exec(OrderDAO orderDAO){

        orderRepositoryJPA.save(orderDAO);

    }

    // 주문 DAO를 DB에 저장
    public void exec(String adminName, OrderDTO orderDTO) {
        switch (adminName) {
            case "computer" :
                computerOrderRepositoryJPA.save(ComputerOrderDAO.fromOrderDTO(orderDTO));
                break;

            case "electronics" :
                electronicsOrderRepositoryJPA.save(ElectronicsOrderDAO.fromOrderDTO(orderDTO));
                break;

            case "energy" :
                energyOrderRepositoryJPA.save(EnergyOrderDAO.fromOrderDTO(orderDTO));
                break;

            case "game" :
                gameOrderRepositoryJPA.save(GameOrderDAO.fromOrderDTO(orderDTO));
                break;

            case "machine" :
                machineOrderRepositoryJPA.save(MachineOrderDAO.fromOrderDTO(orderDTO));
                break;

            case "nano" :
                nanoOrderRepositoryJPA.save(NanoOrderDAO.fromOrderDTO(orderDTO));
                break;

            case "newMaterial" :
                newMaterialOrderRepositoryJPA.save(NewMaterialOrderDAO.fromOrderDTO(orderDTO));
                break;
        }
    }

}
