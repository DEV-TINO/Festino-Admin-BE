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
                .build();
    }

    public static CookDTO fromEnergyCookDAO(EnergyCookDAO energyCookDAO) {
        return CookDTO.builder()
                .cookId(energyCookDAO.getCookId())
                .orderId(energyCookDAO.getOrderId())
                .boothId(energyCookDAO.getBoothId())
                .menuId(energyCookDAO.getMenuId())
                .tableNum(energyCookDAO.getTableNum())
                .date(energyCookDAO.getDate())
                .totalCount(energyCookDAO.getTotalCount())
                .servedCount(energyCookDAO.getServedCount())
                .createAt(energyCookDAO.getCreateAt())
                .isFinish(energyCookDAO.getIsFinish())
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
                .build();
    }
}
