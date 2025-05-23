package com.DevTino.festino_admin.order.domain.DTO;

import com.DevTino.festino_admin.order.domain.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CookDTO {
    UUID cookId;
    UUID orderId;
    UUID boothId;
    UUID menuId;
    Integer tableNum;
    Integer date;
    Integer totalCount;
    Integer servedCount;
    LocalDateTime createAt;
    Boolean isFinish;
    Boolean isService;

    public static CookDTO fromComputerCookDAO(ComputerCookDAO computerCookDAO) {
        return CookDTO.builder()
                .cookId(computerCookDAO.getCookId())
                .orderId(computerCookDAO.getOrderId())
                .boothId(computerCookDAO.getBoothId())
                .menuId(computerCookDAO.getMenuId())
                .tableNum(computerCookDAO.getTableNum())
                .date(computerCookDAO.getDate())
                .totalCount(computerCookDAO.getTotalCount())
                .servedCount(computerCookDAO.getServedCount())
                .createAt(computerCookDAO.getCreateAt())
                .isFinish(computerCookDAO.getIsFinish())
                .isService(computerCookDAO.getIsService())
                .build();
    }

    public static CookDTO fromElectronicsCookDAO(ElectronicsCookDAO electronicsCookDAO) {
        return CookDTO.builder()
                .cookId(electronicsCookDAO.getCookId())
                .orderId(electronicsCookDAO.getOrderId())
                .boothId(electronicsCookDAO.getBoothId())
                .menuId(electronicsCookDAO.getMenuId())
                .tableNum(electronicsCookDAO.getTableNum())
                .date(electronicsCookDAO.getDate())
                .totalCount(electronicsCookDAO.getTotalCount())
                .servedCount(electronicsCookDAO.getServedCount())
                .createAt(electronicsCookDAO.getCreateAt())
                .isFinish(electronicsCookDAO.getIsFinish())
                .isService(electronicsCookDAO.getIsService())
                .build();
    }

    public static CookDTO fromGameCookDAO(GameCookDAO gameCookDAO) {
        return CookDTO.builder()
                .cookId(gameCookDAO.getCookId())
                .orderId(gameCookDAO.getOrderId())
                .boothId(gameCookDAO.getBoothId())
                .menuId(gameCookDAO.getMenuId())
                .tableNum(gameCookDAO.getTableNum())
                .date(gameCookDAO.getDate())
                .totalCount(gameCookDAO.getTotalCount())
                .servedCount(gameCookDAO.getServedCount())
                .createAt(gameCookDAO.getCreateAt())
                .isFinish(gameCookDAO.getIsFinish())
                .isService(gameCookDAO.getIsService())
                .build();
    }

    public static CookDTO fromMachineCookDAO(MachineCookDAO machineCookDAO) {
        return CookDTO.builder()
                .cookId(machineCookDAO.getCookId())
                .orderId(machineCookDAO.getOrderId())
                .boothId(machineCookDAO.getBoothId())
                .menuId(machineCookDAO.getMenuId())
                .tableNum(machineCookDAO.getTableNum())
                .date(machineCookDAO.getDate())
                .totalCount(machineCookDAO.getTotalCount())
                .servedCount(machineCookDAO.getServedCount())
                .createAt(machineCookDAO.getCreateAt())
                .isFinish(machineCookDAO.getIsFinish())
                .isService(machineCookDAO.getIsService())
                .build();
    }

    public static CookDTO fromNanoCookDAO(NanoCookDAO nanoCookDAO) {
        return CookDTO.builder()
                .cookId(nanoCookDAO.getCookId())
                .orderId(nanoCookDAO.getOrderId())
                .boothId(nanoCookDAO.getBoothId())
                .menuId(nanoCookDAO.getMenuId())
                .tableNum(nanoCookDAO.getTableNum())
                .date(nanoCookDAO.getDate())
                .totalCount(nanoCookDAO.getTotalCount())
                .servedCount(nanoCookDAO.getServedCount())
                .createAt(nanoCookDAO.getCreateAt())
                .isFinish(nanoCookDAO.getIsFinish())
                .isService(nanoCookDAO.getIsService())
                .build();
    }

    public static CookDTO fromNewMaterialCookDAO(NewMaterialCookDAO newMaterialCookDAO) {
        return CookDTO.builder()
                .cookId(newMaterialCookDAO.getCookId())
                .orderId(newMaterialCookDAO.getOrderId())
                .boothId(newMaterialCookDAO.getBoothId())
                .menuId(newMaterialCookDAO.getMenuId())
                .tableNum(newMaterialCookDAO.getTableNum())
                .date(newMaterialCookDAO.getDate())
                .totalCount(newMaterialCookDAO.getTotalCount())
                .servedCount(newMaterialCookDAO.getServedCount())
                .createAt(newMaterialCookDAO.getCreateAt())
                .isFinish(newMaterialCookDAO.getIsFinish())
                .isService(newMaterialCookDAO.getIsService())
                .build();
    }

    public static CookDTO fromDesignCookDAO(DesignCookDAO designCookDAO) {
        return CookDTO.builder()
                .cookId(designCookDAO.getCookId())
                .orderId(designCookDAO.getOrderId())
                .boothId(designCookDAO.getBoothId())
                .menuId(designCookDAO.getMenuId())
                .tableNum(designCookDAO.getTableNum())
                .date(designCookDAO.getDate())
                .totalCount(designCookDAO.getTotalCount())
                .servedCount(designCookDAO.getServedCount())
                .createAt(designCookDAO.getCreateAt())
                .isFinish(designCookDAO.getIsFinish())
                .isService(designCookDAO.getIsService())
                .build();
    }


    public static CookDTO fromAbstractCookDAO(AbstractCookDAO abstractCookDAO) {

        return CookDTO.builder()
                .cookId(abstractCookDAO.getCookId())
                .orderId(abstractCookDAO.getOrderId())
                .boothId(abstractCookDAO.getBoothId())
                .menuId(abstractCookDAO.getMenuId())
                .tableNum(abstractCookDAO.getTableNum())
                .date(abstractCookDAO.getDate())
                .totalCount(abstractCookDAO.getTotalCount())
                .servedCount(abstractCookDAO.getServedCount())
                .createAt(abstractCookDAO.getCreateAt())
                .isFinish(abstractCookDAO.getIsFinish())
                .isService(abstractCookDAO.getIsService())
                .build();

    }
}
