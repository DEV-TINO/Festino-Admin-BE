package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderDAOBean {

    ComputerOrderRepositoryJPA computerOrderRepositoryJPA;
    ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA;
    EnergyOrderRepositoryJPA energyOrderRepositoryJPA;
    GameOrderRepositoryJPA gameOrderRepositoryJPA;
    MachineOrderRepositoryJPA machineOrderRepositoryJPA;
    NanoOrderRepositoryJPA nanoOrderRepositoryJPA;
    NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA;
    DesignOrderRepositoryJPA designOrderRepositoryJPA;

    @Autowired
    public SaveOrderDAOBean(ComputerOrderRepositoryJPA computerOrderRepositoryJPA, ElectronicsOrderRepositoryJPA electronicsOrderRepositoryJPA, EnergyOrderRepositoryJPA energyOrderRepositoryJPA, GameOrderRepositoryJPA gameOrderRepositoryJPA, MachineOrderRepositoryJPA machineOrderRepositoryJPA, NanoOrderRepositoryJPA nanoOrderRepositoryJPA, NewMaterialOrderRepositoryJPA newMaterialOrderRepositoryJPA, DesignOrderRepositoryJPA designOrderRepositoryJPA) {
        this.computerOrderRepositoryJPA = computerOrderRepositoryJPA;
        this.electronicsOrderRepositoryJPA = electronicsOrderRepositoryJPA;
        this.energyOrderRepositoryJPA = energyOrderRepositoryJPA;
        this.gameOrderRepositoryJPA = gameOrderRepositoryJPA;
        this.machineOrderRepositoryJPA = machineOrderRepositoryJPA;
        this.nanoOrderRepositoryJPA = nanoOrderRepositoryJPA;
        this.newMaterialOrderRepositoryJPA = newMaterialOrderRepositoryJPA;
        this.designOrderRepositoryJPA = designOrderRepositoryJPA;
    }

    // 주문 DAO를 DB에 저장
    public void exec(String adminName, OrderDTO orderDTO) {
        switch (adminName) {
            // 컴퓨터 공학과에 저장
            case "computer" :
                computerOrderRepositoryJPA.save(ComputerOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 전자공학부에 저장
            case "electronics" :
                electronicsOrderRepositoryJPA.save(ElectronicsOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 에너지전기공학과에 저장
            case "energy" :
                energyOrderRepositoryJPA.save(EnergyOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 게임공학과에 저장
            case "game" :
                gameOrderRepositoryJPA.save(GameOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 기계공학과에 저장
            case "machine" :
                machineOrderRepositoryJPA.save(MachineOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 나노반도체공학과에 저장
            case "nano" :
                nanoOrderRepositoryJPA.save(NanoOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 신소재공학과에 저장
            case "newMaterial" :
                newMaterialOrderRepositoryJPA.save(NewMaterialOrderDAO.fromOrderDTO(orderDTO));
                break;

            // 디자인공학부에 저장
            case "design" :
                designOrderRepositoryJPA.save(DesignOrderDAO.fromOrderDTO(orderDTO));
                break;
        }
    }

}
