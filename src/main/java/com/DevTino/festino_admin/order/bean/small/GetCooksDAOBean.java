package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetCooksDAOBean {

    ComputerCookRepositoryJPA computerCookRepositoryJPA;
    ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA;
    EnergyCookRepositoryJPA energyCookRepositoryJPA;
    GameCookRepositoryJPA gameCookRepositoryJPA;
    MachineCookRepositoryJPA machineCookRepositoryJPA;
    NanoCookRepositoryJPA nanoCookRepositoryJPA;
    NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA;
    DesignCookRepositoryJPA designCookRepositoryJPA;

    @Autowired
    public GetCooksDAOBean(ComputerCookRepositoryJPA computerCookRepositoryJPA, ElectronicsCookRepositoryJPA electronicsCookRepositoryJPA, EnergyCookRepositoryJPA energyCookRepositoryJPA, GameCookRepositoryJPA gameCookRepositoryJPA, MachineCookRepositoryJPA machineCookRepositoryJPA, NanoCookRepositoryJPA nanoCookRepositoryJPA, NewMaterialCookRepositoryJPA newMaterialCookRepositoryJPA, DesignCookRepositoryJPA designCookRepositoryJPA) {
        this.computerCookRepositoryJPA = computerCookRepositoryJPA;
        this.electronicsCookRepositoryJPA = electronicsCookRepositoryJPA;
        this.energyCookRepositoryJPA = energyCookRepositoryJPA;
        this.gameCookRepositoryJPA = gameCookRepositoryJPA;
        this.machineCookRepositoryJPA = machineCookRepositoryJPA;
        this.nanoCookRepositoryJPA = nanoCookRepositoryJPA;
        this.newMaterialCookRepositoryJPA = newMaterialCookRepositoryJPA;
        this.designCookRepositoryJPA = designCookRepositoryJPA;
    }

    // orderId에 해당하는 Cook 찾아서 List로 반환
    public List<CookDTO> exec(String adminName, UUID orderId){

        // 학과로 구분된 cook 리스트를 담아줄 cookDTO 빈 리스트 생성
        List<CookDTO> cookDTOList = new ArrayList<>();

        switch (adminName) {
            // 컴퓨터 공학과에서 조회
            case "computer" :
                List<ComputerCookDAO> computerCookDAOList = computerCookRepositoryJPA.findAllByOrderId(orderId);
                if(computerCookDAOList.isEmpty()) return new ArrayList<>();
                System.out.println(computerCookDAOList);

                for(ComputerCookDAO computerCookDAO : computerCookDAOList) {
                    cookDTOList.add(CookDTO.fromComputerCookDAO(computerCookDAO));
                }
                break;

            // 전자공학부에서 조회
            case "electronics" :
                List<ElectronicsCookDAO> electronicsCookDAOList = electronicsCookRepositoryJPA.findAllByOrderId(orderId);
                if(electronicsCookDAOList.isEmpty()) return new ArrayList<>();

                for(ElectronicsCookDAO electronicsCookDAO : electronicsCookDAOList) {
                    cookDTOList.add(CookDTO.fromElectronicsCookDAO(electronicsCookDAO));
                }
                break;

            // 에너지전기공학과에서 조회
            case "energy" :
                List<EnergyCookDAO> energyCookDAOList = energyCookRepositoryJPA.findAllByOrderId(orderId);
                if(energyCookDAOList.isEmpty()) return new ArrayList<>();

                for(EnergyCookDAO energyCookDAO : energyCookDAOList) {
                    cookDTOList.add(CookDTO.fromEnergyCookDAO(energyCookDAO));
                }
                break;

            // 게임공학과에서 조회
            case "game" :
                List<GameCookDAO> gameCookDAOList = gameCookRepositoryJPA.findAllByOrderId(orderId);
                if(gameCookDAOList.isEmpty()) return new ArrayList<>();

                for(GameCookDAO gameCookDAO : gameCookDAOList) {
                    cookDTOList.add(CookDTO.fromGameCookDAO(gameCookDAO));
                }
                break;

            // 기계공학과에서 조회
            case "machine" :
                List<MachineCookDAO> machineCookDAOList = machineCookRepositoryJPA.findAllByOrderId(orderId);
                if(machineCookDAOList.isEmpty()) return new ArrayList<>();

                for(MachineCookDAO machineCookDAO : machineCookDAOList) {
                    cookDTOList.add(CookDTO.fromMachineCookDAO(machineCookDAO));
                }
                break;

            // 나노반도체공학과에서 조회
            case "nano" :
                List<NanoCookDAO> nanoCookDAOList = nanoCookRepositoryJPA.findAllByOrderId(orderId);
                if(nanoCookDAOList.isEmpty()) return new ArrayList<>();

                for(NanoCookDAO nanoCookDAO : nanoCookDAOList) {
                    cookDTOList.add(CookDTO.fromNanoCookDAO(nanoCookDAO));
                }
                break;

            // 신소재공학과에서 조회
            case "newMaterial" :
                List<NewMaterialCookDAO> newMaterialCookDAOList = newMaterialCookRepositoryJPA.findAllByOrderId(orderId);
                if(newMaterialCookDAOList.isEmpty()) return new ArrayList<>();

                for(NewMaterialCookDAO newMaterialCookDAO : newMaterialCookDAOList) {
                    cookDTOList.add(CookDTO.fromNewMaterialCookDAO(newMaterialCookDAO));
                }
                break;

            // 디자인공학부에서 조회
            case "design" :
                List<DesignCookDAO> designCookDAOList = designCookRepositoryJPA.findAllByOrderId(orderId);
                if(designCookDAOList.isEmpty()) return new ArrayList<>();

                for(DesignCookDAO designCookDAO : designCookDAOList) {
                    cookDTOList.add(CookDTO.fromDesignCookDAO(designCookDAO));
                }
                break;
        }
        return cookDTOList;
    }


    // menuId, isFinish, date로 Cook 오래된순 전체 조회
    public List<CookDTO> exec(String adminName, UUID menuId, Boolean isFinish, Integer date){

        // 학과로 구분된 cook 리스트를 담아줄 cookDTO 빈 리스트 생성
        List<CookDTO> cookDTOList = new ArrayList<>();

        switch (adminName) {
            // 컴퓨터 공학과에서 조회
            case "computer" :
                List<ComputerCookDAO> computerCookDAOList = computerCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(computerCookDAOList.isEmpty()) return new ArrayList<>();


                for(ComputerCookDAO computerCookDAO : computerCookDAOList) {
                    cookDTOList.add(CookDTO.fromComputerCookDAO(computerCookDAO));
                }
                break;

            // 전자공학부에서 조회
            case "electronics" :
                List<ElectronicsCookDAO> electronicsCookDAOList = electronicsCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(electronicsCookDAOList.isEmpty()) return new ArrayList<>();

                for(ElectronicsCookDAO electronicsCookDAO : electronicsCookDAOList) {
                    cookDTOList.add(CookDTO.fromElectronicsCookDAO(electronicsCookDAO));
                }
                break;

            // 에너지전기공학과에서 조회
            case "energy" :
                List<EnergyCookDAO> energyCookDAOList = energyCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(energyCookDAOList.isEmpty()) return new ArrayList<>();

                for(EnergyCookDAO energyCookDAO : energyCookDAOList) {
                    cookDTOList.add(CookDTO.fromEnergyCookDAO(energyCookDAO));
                }
                break;

            // 게임공학과에서 조회
            case "game" :
                List<GameCookDAO> gameCookDAOList = gameCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(gameCookDAOList.isEmpty()) return new ArrayList<>();

                for(GameCookDAO gameCookDAO : gameCookDAOList) {
                    cookDTOList.add(CookDTO.fromGameCookDAO(gameCookDAO));
                }
                break;

            // 기계공학과에서 조회
            case "machine" :
                List<MachineCookDAO> machineCookDAOList = machineCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(machineCookDAOList.isEmpty()) return new ArrayList<>();

                for(MachineCookDAO machineCookDAO : machineCookDAOList) {
                    cookDTOList.add(CookDTO.fromMachineCookDAO(machineCookDAO));
                }
                break;

            // 나노반도체공학과에서 조회
            case "nano" :
                List<NanoCookDAO> nanoCookDAOList = nanoCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(nanoCookDAOList.isEmpty()) return new ArrayList<>();

                for(NanoCookDAO nanoCookDAO : nanoCookDAOList) {
                    cookDTOList.add(CookDTO.fromNanoCookDAO(nanoCookDAO));
                }
                break;

            // 신소재공학과에서 조회
            case "newMaterial" :
                List<NewMaterialCookDAO> newMaterialCookDAOList = newMaterialCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(newMaterialCookDAOList.isEmpty()) return new ArrayList<>();

                for(NewMaterialCookDAO newMaterialCookDAO : newMaterialCookDAOList) {
                    cookDTOList.add(CookDTO.fromNewMaterialCookDAO(newMaterialCookDAO));
                }
                break;

            // 디자인공학부에서 조회
            case "design" :
                List<DesignCookDAO> designCookDAOList = designCookRepositoryJPA.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
                if(designCookDAOList.isEmpty()) return new ArrayList<>();

                for(DesignCookDAO designCookDAO : designCookDAOList) {
                    cookDTOList.add(CookDTO.fromDesignCookDAO(designCookDAO));
                }
                break;
        }
        return cookDTOList;
    }



    // menuId, date, isFinish, isService로 Cook 전체 조회
    public List<CookDTO> exec(String adminName, UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        // 학과로 구분된 cook 리스트를 담아줄 cookDTO 빈 리스트 생성
        List<CookDTO> cookDTOList = new ArrayList<>();

        switch (adminName) {
            // 컴퓨터 공학과에서 조회
            case "computer" :
                List<ComputerCookDAO> computerCookDAOList = computerCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(computerCookDAOList.isEmpty()) return new ArrayList<>();

                for(ComputerCookDAO computerCookDAO : computerCookDAOList) {
                    cookDTOList.add(CookDTO.fromComputerCookDAO(computerCookDAO));
                }
                break;

            // 전자공학부에서 조회
            case "electronics" :
                List<ElectronicsCookDAO> electronicsCookDAOList = electronicsCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(electronicsCookDAOList.isEmpty()) return new ArrayList<>();

                for(ElectronicsCookDAO electronicsCookDAO : electronicsCookDAOList) {
                    cookDTOList.add(CookDTO.fromElectronicsCookDAO(electronicsCookDAO));
                }
                break;

            // 에너지전기공학과에서 조회
            case "energy" :
                List<EnergyCookDAO> energyCookDAOList = energyCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(energyCookDAOList.isEmpty()) return new ArrayList<>();

                for(EnergyCookDAO energyCookDAO : energyCookDAOList) {
                    cookDTOList.add(CookDTO.fromEnergyCookDAO(energyCookDAO));
                }
                break;

            // 게임공학과에서 조회
            case "game" :
                List<GameCookDAO> gameCookDAOList = gameCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(gameCookDAOList.isEmpty()) return new ArrayList<>();

                for(GameCookDAO gameCookDAO : gameCookDAOList) {
                    cookDTOList.add(CookDTO.fromGameCookDAO(gameCookDAO));
                }
                break;

            // 기계공학과에서 조회
            case "machine" :
                List<MachineCookDAO> machineCookDAOList = machineCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(machineCookDAOList.isEmpty()) return new ArrayList<>();

                for(MachineCookDAO machineCookDAO : machineCookDAOList) {
                    cookDTOList.add(CookDTO.fromMachineCookDAO(machineCookDAO));
                }
                break;

            // 나노반도체공학과에서 조회
            case "nano" :
                List<NanoCookDAO> nanoCookDAOList = nanoCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(nanoCookDAOList.isEmpty()) return new ArrayList<>();

                for(NanoCookDAO nanoCookDAO : nanoCookDAOList) {
                    cookDTOList.add(CookDTO.fromNanoCookDAO(nanoCookDAO));
                }
                break;

            // 신소재공학과에서 조회
            case "newMaterial" :
                List<NewMaterialCookDAO> newMaterialCookDAOList = newMaterialCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(newMaterialCookDAOList.isEmpty()) return new ArrayList<>();

                for(NewMaterialCookDAO newMaterialCookDAO : newMaterialCookDAOList) {
                    cookDTOList.add(CookDTO.fromNewMaterialCookDAO(newMaterialCookDAO));
                }
                break;

            // 디자인공학부에서 조회
            case "design" :
                List<DesignCookDAO> designCookDAOList = designCookRepositoryJPA.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
                if(designCookDAOList.isEmpty()) return new ArrayList<>();

                for(DesignCookDAO designCookDAO : designCookDAOList) {
                    cookDTOList.add(CookDTO.fromDesignCookDAO(designCookDAO));
                }
                break;
        }
        return cookDTOList;
    }

    // menuId, date, isFinish 로 Cook 전체 조회
    public List<CookDTO> exec(String adminName, UUID menuId, Integer date, Boolean isFinish){

        // 학과로 구분된 cook 리스트를 담아줄 cookDTO 빈 리스트 생성
        List<CookDTO> cookDTOList = new ArrayList<>();

        switch (adminName) {
            // 컴퓨터 공학과에서 조회
            case "computer" :
                List<ComputerCookDAO> computerCookDAOList = computerCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(computerCookDAOList.isEmpty()) return new ArrayList<>();

                for(ComputerCookDAO computerCookDAO : computerCookDAOList) {
                    cookDTOList.add(CookDTO.fromComputerCookDAO(computerCookDAO));
                }
                break;

            // 전자공학부에서 조회
            case "electronics" :
                List<ElectronicsCookDAO> electronicsCookDAOList = electronicsCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(electronicsCookDAOList.isEmpty()) return new ArrayList<>();

                for(ElectronicsCookDAO electronicsCookDAO : electronicsCookDAOList) {
                    cookDTOList.add(CookDTO.fromElectronicsCookDAO(electronicsCookDAO));
                }
                break;

            // 에너지전기공학과에서 조회
            case "energy" :
                List<EnergyCookDAO> energyCookDAOList = energyCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(energyCookDAOList.isEmpty()) return new ArrayList<>();

                for(EnergyCookDAO energyCookDAO : energyCookDAOList) {
                    cookDTOList.add(CookDTO.fromEnergyCookDAO(energyCookDAO));
                }
                break;

            // 게임공학과에서 조회
            case "game" :
                List<GameCookDAO> gameCookDAOList = gameCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(gameCookDAOList.isEmpty()) return new ArrayList<>();

                for(GameCookDAO gameCookDAO : gameCookDAOList) {
                    cookDTOList.add(CookDTO.fromGameCookDAO(gameCookDAO));
                }
                break;

            // 기계공학과에서 조회
            case "machine" :
                List<MachineCookDAO> machineCookDAOList = machineCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(machineCookDAOList.isEmpty()) return new ArrayList<>();

                for(MachineCookDAO machineCookDAO : machineCookDAOList) {
                    cookDTOList.add(CookDTO.fromMachineCookDAO(machineCookDAO));
                }
                break;

            // 나노반도체공학과에서 조회
            case "nano" :
                List<NanoCookDAO> nanoCookDAOList = nanoCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(nanoCookDAOList.isEmpty()) return new ArrayList<>();

                for(NanoCookDAO nanoCookDAO : nanoCookDAOList) {
                    cookDTOList.add(CookDTO.fromNanoCookDAO(nanoCookDAO));
                }
                break;

            // 신소재공학과에서 조회
            case "newMaterial" :
                List<NewMaterialCookDAO> newMaterialCookDAOList = newMaterialCookRepositoryJPA.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
                if(newMaterialCookDAOList.isEmpty()) return new ArrayList<>();

                for(NewMaterialCookDAO newMaterialCookDAO : newMaterialCookDAOList) {
                    cookDTOList.add(CookDTO.fromNewMaterialCookDAO(newMaterialCookDAO));
                }
                break;
        }
        return cookDTOList;

    }

}
