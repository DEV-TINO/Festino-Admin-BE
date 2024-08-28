package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
public class GetCookDAOBean {

    ComputerCookRepositoryJPA computerCookRepositoryJPA;
    ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA;
    EnergyCookRepositoryJPA energyCookRepositoryJPA;
    GameCookRepositoryJPA gameCookRepositoryJPA;
    MachineCookRepositoryJPA machineCookRepositoryJPA;
    NanoCookRepositoryJPA nanoCookRepositoryJPA;
    NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA;

    @Autowired
    public GetCookDAOBean(ComputerCookRepositoryJPA computerCookRepositoryJPA, ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA, EnergyCookRepositoryJPA energyCookRepositoryJPA, GameCookRepositoryJPA gameCookRepositoryJPA, MachineCookRepositoryJPA machineCookRepositoryJPA, NanoCookRepositoryJPA nanoCookRepositoryJPA, NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA) {
        this.computerCookRepositoryJPA = computerCookRepositoryJPA;
        this.electronicsCookRepositoryJPA = electronicsCookRepositoryJPA;
        this.energyCookRepositoryJPA = energyCookRepositoryJPA;
        this.gameCookRepositoryJPA = gameCookRepositoryJPA;
        this.machineCookRepositoryJPA = machineCookRepositoryJPA;
        this.nanoCookRepositoryJPA = nanoCookRepositoryJPA;
        this.newMaterialCookRepositoryJPA = newMaterialCookRepositoryJPA;
    }

    // cookId로 DAO 찾아서 반환하는 메서드
    public CookDTO exec(String adminName, UUID cookId){

        switch (adminName) {
            // 컴퓨터 공학과에서 조회
            case "computer" :
                // cookId 해당 Cook DAO 찾고
                ComputerCookDAO computerCookDAO = computerCookRepositoryJPA.findById(cookId).orElse(null);
                if(computerCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromComputerCookDAO(computerCookDAO);

            // 전자공학부에서 조회
            case "electronics" :
                // cookId 해당 Cook DAO 찾고
                ElectronicsCookDAO electronicsCookDAO = electronicsCookRepositoryJPA.findById(cookId).orElse(null);
                if(electronicsCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromElectronicsCookDAO(electronicsCookDAO);

            // 에너지전기공학과에서 조회
            case "energy" :
                // cookId 해당 Cook DAO 찾고
                EnergyCookDAO energyCookDAO = energyCookRepositoryJPA.findById(cookId).orElse(null);
                if(energyCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromEnergyCookDAO(energyCookDAO);

            // 게임공학과에서 조회
            case "game" :
                // cookId 해당 Cook DAO 찾고
                GameCookDAO gameCookDAO = gameCookRepositoryJPA.findById(cookId).orElse(null);
                if(gameCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromGameCookDAO(gameCookDAO);

            // 기계공학과에서 조회
            case "machine" :
                // cookId 해당 Cook DAO 찾고
                MachineCookDAO machineCookDAO = machineCookRepositoryJPA.findById(cookId).orElse(null);
                if(machineCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromMachineCookDAO(machineCookDAO);

            // 나노반도체공학과에서 조회
            case "nano" :
                // cookId 해당 Cook DAO 찾고
                NanoCookDAO nanoCookDAO = nanoCookRepositoryJPA.findById(cookId).orElse(null);
                if(nanoCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromNanoCookDAO(nanoCookDAO);

            // 신소재공학과에서 조회
            case "newMaterial" :
                // cookId 해당 Cook DAO 찾고
                NewMaterialCookDAO newMaterialCookDAO = newMaterialCookRepositoryJPA.findById(cookId).orElse(null);
                if(newMaterialCookDAO == null) return null;

                // cookDTO 타입으로 변경후 반환
                return CookDTO.fromNewMaterialCookDAO(newMaterialCookDAO);

            default:
                return null;
        }
    }

}
