package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveCookDAOBean {

    CookRepositoryJPA cookRepositoryJPA;

    ComputerCookRepositoryJPA computerCookRepositoryJPA;
    ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA;
    EnergyCookRepositoryJPA energyCookRepositoryJPA;
    GameCookRepositoryJPA gameCookRepositoryJPA;
    MachineCookRepositoryJPA machineCookRepositoryJPA;
    NanoCookRepositoryJPA nanoCookRepositoryJPA;
    NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA;

    @Autowired
    public SaveCookDAOBean(CookRepositoryJPA cookRepositoryJPA, ComputerCookRepositoryJPA computerCookRepositoryJPA, ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA, EnergyCookRepositoryJPA energyCookRepositoryJPA, GameCookRepositoryJPA gameCookRepositoryJPA, MachineCookRepositoryJPA machineCookRepositoryJPA, NanoCookRepositoryJPA nanoCookRepositoryJPA, NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA) {
        this.cookRepositoryJPA = cookRepositoryJPA;
        this.computerCookRepositoryJPA = computerCookRepositoryJPA;
        this.electronicsCookRepositoryJPA = electronicsCookRepositoryJPA;
        this.energyCookRepositoryJPA = energyCookRepositoryJPA;
        this.gameCookRepositoryJPA = gameCookRepositoryJPA;
        this.machineCookRepositoryJPA = machineCookRepositoryJPA;
        this.nanoCookRepositoryJPA = nanoCookRepositoryJPA;
        this.newMaterialCookRepositoryJPA = newMaterialCookRepositoryJPA;
    }

    // 조리 DAO를 DB에 저장
    public void exec(CookDAO cookDAO){

        cookRepositoryJPA.save(cookDAO);

    }

    // 조리 DAO 리스트를 DB에 저장
    public void exec(List<CookDAO> cookDAOList){

        cookRepositoryJPA.saveAll(cookDAOList);

    }

    public void exec(List<CookDTO> cookDTOList, String adminName){

        switch(adminName) {

            // 컴퓨터 공학과
            case "computer":
                // Cook 리스트 생성
                List<ComputerCookDAO> computerCookDAOList = new ArrayList<>();

                // for문을 통해
                for (CookDTO cookDTO : cookDTOList) {
                    computerCookDAOList.add(ComputerCookDAO.fromCookDTO(cookDTO));
                }
                computerCookRepositoryJPA.saveAll(computerCookDAOList);
                break;

            case "electronics":
                List<ElectronicsCookDAO> electronicsCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    electronicsCookDAOList.add(ElectronicsCookDAO.fromCookDTO(cookDTO));
                }
                electronicsCookRepositoryJPA.saveAll(electronicsCookDAOList);
                break;

            case "energy" :
                List<EnergyCookDAO> energyCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    energyCookDAOList.add(EnergyCookDAO.fromCookDTO(cookDTO));
                }
                energyCookRepositoryJPA.saveAll(energyCookDAOList);
                break;

            case "game" :
                List<GameCookDAO> gameCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    gameCookDAOList.add(GameCookDAO.fromCookDTO(cookDTO));
                }
                gameCookRepositoryJPA.saveAll(gameCookDAOList);
                break;

            case "machine" :
                List<MachineCookDAO> machineCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    machineCookDAOList.add(MachineCookDAO.fromCookDTO(cookDTO));
                }
                machineCookRepositoryJPA.saveAll(machineCookDAOList);
                break;

            case "nano" :
                List<NanoCookDAO> nanoCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    nanoCookDAOList.add(NanoCookDAO.fromCookDTO(cookDTO));
                }
                nanoCookRepositoryJPA.saveAll(nanoCookDAOList);
                break;

            case "newMaterial" :
                List<NewMaterialCookDAO> newMaterialCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    newMaterialCookDAOList.add(NewMaterialCookDAO.fromCookDTO(cookDTO));
                }
                newMaterialCookRepositoryJPA.saveAll(newMaterialCookDAOList);
                break;
        }
    }

}
