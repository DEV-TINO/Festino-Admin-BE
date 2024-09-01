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

    ComputerCookRepositoryJPA computerCookRepositoryJPA;
    ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA;
    EnergyCookRepositoryJPA energyCookRepositoryJPA;
    GameCookRepositoryJPA gameCookRepositoryJPA;
    MachineCookRepositoryJPA machineCookRepositoryJPA;
    NanoCookRepositoryJPA nanoCookRepositoryJPA;
    NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA;
    DesignCookRepositoryJPA designCookRepositoryJPA;

    @Autowired
    public SaveCookDAOBean(ComputerCookRepositoryJPA computerCookRepositoryJPA, ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA, EnergyCookRepositoryJPA energyCookRepositoryJPA, GameCookRepositoryJPA gameCookRepositoryJPA, MachineCookRepositoryJPA machineCookRepositoryJPA, NanoCookRepositoryJPA nanoCookRepositoryJPA, NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA, DesignCookRepositoryJPA designCookRepositoryJPA) {
        this.computerCookRepositoryJPA = computerCookRepositoryJPA;
        this.electronicsCookRepositoryJPA = electronicsCookRepositoryJPA;
        this.energyCookRepositoryJPA = energyCookRepositoryJPA;
        this.gameCookRepositoryJPA = gameCookRepositoryJPA;
        this.machineCookRepositoryJPA = machineCookRepositoryJPA;
        this.nanoCookRepositoryJPA = nanoCookRepositoryJPA;
        this.newMaterialCookRepositoryJPA = newMaterialCookRepositoryJPA;
        this.designCookRepositoryJPA = designCookRepositoryJPA;
    }

    // 각 학과로 구분하여 조리 DAO를 DB에 저장
    public void exec(String adminName, CookDTO cookDTO){

        switch(adminName) {

            // 컴퓨터 공학과 저장
            case "computer":
                computerCookRepositoryJPA.save(ComputerCookDAO.fromCookDTO(cookDTO));
                break;

            // 전자공학부 저장
            case "electronics":
                electronicsCookRepositoryJPA.save(ElectronicsCookDAO.fromCookDTO(cookDTO));
                break;

            // 에너지전기공학과 저장
            case "energy" :
                energyCookRepositoryJPA.save(EnergyCookDAO.fromCookDTO(cookDTO));
                break;

            // 게임공학과 저장
            case "game" :
                gameCookRepositoryJPA.save(GameCookDAO.fromCookDTO(cookDTO));
                break;

            // 기계공학과 저장
            case "machine" :
                machineCookRepositoryJPA.save(MachineCookDAO.fromCookDTO(cookDTO));
                break;

            // 나노반도체공학과 저장
            case "nano" :
                nanoCookRepositoryJPA.save(NanoCookDAO.fromCookDTO(cookDTO));
                break;

            // 신소재공학과 저장
            case "newMaterial" :
                newMaterialCookRepositoryJPA.save(NewMaterialCookDAO.fromCookDTO(cookDTO));
                break;

            // 디자인공학부 저장
            case "design" :
                designCookRepositoryJPA.save(DesignCookDAO.fromCookDTO(cookDTO));
                break;
        }
    }

    // 각 학과로 구분해 조리 DAO 리스트를 DB에 저장
    public void exec(String adminName, List<CookDTO> cookDTOList){

        switch(adminName) {

            // 컴퓨터 공학과에 cook 리스트 저장
            case "computer":
                List<ComputerCookDAO> computerCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    computerCookDAOList.add(ComputerCookDAO.fromCookDTO(cookDTO));
                }
                computerCookRepositoryJPA.saveAll(computerCookDAOList);
                break;

            // 전자공학부에 cook 리스트 저장
            case "electronics":
                List<ElectronicsCookDAO> electronicsCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    electronicsCookDAOList.add(ElectronicsCookDAO.fromCookDTO(cookDTO));
                }
                electronicsCookRepositoryJPA.saveAll(electronicsCookDAOList);
                break;

            // 에너지 전기공학과에 cook 리스트 저장
            case "energy" :
                List<EnergyCookDAO> energyCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    energyCookDAOList.add(EnergyCookDAO.fromCookDTO(cookDTO));
                }
                energyCookRepositoryJPA.saveAll(energyCookDAOList);
                break;

            // 게임공학과에 cook 리스트 저장
            case "game" :
                List<GameCookDAO> gameCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    gameCookDAOList.add(GameCookDAO.fromCookDTO(cookDTO));
                }
                gameCookRepositoryJPA.saveAll(gameCookDAOList);
                break;

            // 기계공학과에 cook 리스트 저장
            case "machine" :
                List<MachineCookDAO> machineCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    machineCookDAOList.add(MachineCookDAO.fromCookDTO(cookDTO));
                }
                machineCookRepositoryJPA.saveAll(machineCookDAOList);
                break;

            // 나노반도체공학과에 cook 리스트 저장
            case "nano" :
                List<NanoCookDAO> nanoCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    nanoCookDAOList.add(NanoCookDAO.fromCookDTO(cookDTO));
                }
                nanoCookRepositoryJPA.saveAll(nanoCookDAOList);
                break;

            // 신소재공학과에 cook 리스트 저장
            case "newMaterial" :
                List<NewMaterialCookDAO> newMaterialCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    newMaterialCookDAOList.add(NewMaterialCookDAO.fromCookDTO(cookDTO));
                }
                newMaterialCookRepositoryJPA.saveAll(newMaterialCookDAOList);
                break;

            // 디자인공학부에 cook 리스트 저장
            case "design" :
                List<DesignCookDAO> designCookDAOList = new ArrayList<>();

                for (CookDTO cookDTO : cookDTOList) {
                    designCookDAOList.add(DesignCookDAO.fromCookDTO(cookDTO));
                }
                designCookRepositoryJPA.saveAll(designCookDAOList);
                break;
        }
    }

}
