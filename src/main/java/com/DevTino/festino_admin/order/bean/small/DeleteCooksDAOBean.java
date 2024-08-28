package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeleteCooksDAOBean {

    ComputerCookRepositoryJPA computerCookRepositoryJPA;
    ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA;
    EnergyCookRepositoryJPA energyCookRepositoryJPA;
    GameCookRepositoryJPA gameCookRepositoryJPA;
    MachineCookRepositoryJPA machineCookRepositoryJPA;
    NanoCookRepositoryJPA nanoCookRepositoryJPA;
    NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA;

    @Autowired
    public DeleteCooksDAOBean(ComputerCookRepositoryJPA computerCookRepositoryJPA, ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA, EnergyCookRepositoryJPA energyCookRepositoryJPA, GameCookRepositoryJPA gameCookRepositoryJPA, MachineCookRepositoryJPA machineCookRepositoryJPA, NanoCookRepositoryJPA nanoCookRepositoryJPA, NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA) {
        this.computerCookRepositoryJPA = computerCookRepositoryJPA;
        this.electronicsCookRepositoryJPA = electronicsCookRepositoryJPA;
        this.energyCookRepositoryJPA = energyCookRepositoryJPA;
        this.gameCookRepositoryJPA = gameCookRepositoryJPA;
        this.machineCookRepositoryJPA = machineCookRepositoryJPA;
        this.nanoCookRepositoryJPA = nanoCookRepositoryJPA;
        this.newMaterialCookRepositoryJPA = newMaterialCookRepositoryJPA;
    }

    // CookDAO 리스트를 삭제
    public void exec(String adminName, List<CookDTO> cookDTOList){

        switch(adminName) {

            // 컴퓨터공학과 Cook 리스트 삭제
            case "computer":
                // Cook 리스트 생성
                List<ComputerCookDAO> computerCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    computerCookDAOList.add(ComputerCookDAO.fromCookDTO(cookDTO));
                }
                computerCookRepositoryJPA.deleteAll(computerCookDAOList);
                break;

            // 전자공학부 Cook 리스트 삭제
            case "electronics":
                List<ElectronicsCookDAO> electronicsCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    electronicsCookDAOList.add(ElectronicsCookDAO.fromCookDTO(cookDTO));
                }
                electronicsCookRepositoryJPA.deleteAll(electronicsCookDAOList);
                break;

            // 에너지전기공학과 Cook 리스트 삭제
            case "energy":
                List<EnergyCookDAO> energyCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    energyCookDAOList.add(EnergyCookDAO.fromCookDTO(cookDTO));
                }
                energyCookRepositoryJPA.deleteAll(energyCookDAOList);
                break;

            // 게임공학과 Cook 리스트 삭제
            case "game":
                List<GameCookDAO> gameCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    gameCookDAOList.add(GameCookDAO.fromCookDTO(cookDTO));
                }
                gameCookRepositoryJPA.deleteAll(gameCookDAOList);
                break;

            // 기계공학과 Cook 리스트 삭제
            case "machine":
                List<MachineCookDAO> machineCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    machineCookDAOList.add(MachineCookDAO.fromCookDTO(cookDTO));
                }
                machineCookRepositoryJPA.deleteAll(machineCookDAOList);
                break;

            // 나노반도체공학과 Cook 리스트 삭제
            case "nano":
                List<NanoCookDAO> nanoCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    nanoCookDAOList.add(NanoCookDAO.fromCookDTO(cookDTO));
                }
                nanoCookRepositoryJPA.deleteAll(nanoCookDAOList);
                break;

            // 신소재공학과 Cook 리스트 삭제
            case "newMaterial":
                List<NewMaterialCookDAO> newMaterialCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    newMaterialCookDAOList.add(NewMaterialCookDAO.fromCookDTO(cookDTO));
                }
                newMaterialCookRepositoryJPA.deleteAll(newMaterialCookDAOList);
                break;
        }
    }
}
