package com.DevTino.festino_admin.order.domain.DTO;

import com.DevTino.festino_admin.order.domain.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDTO {
    Integer orderNum;
    UUID orderId;
    UUID boothId;
    OrderType orderType;
    Integer tableNum;
    Integer date;
    String userName;
    String phoneNum;
    String note;
    Integer totalPrice;
    Boolean isDeposit;
    Boolean isCoupon;
    Boolean isService;
    LocalDateTime createAt;
    LocalDateTime finishAt;
    List<MenuInfoDTO> menuInfo;

    public static OrderDTO fromComputerOrderDAO(ComputerOrderDAO computerOrderDAO) {
        return OrderDTO.builder()
                .orderNum(computerOrderDAO.getOrderNum())
                .orderId(computerOrderDAO.getOrderId())
                .boothId(computerOrderDAO.getBoothId())
                .orderType(computerOrderDAO.getOrderType())
                .tableNum(computerOrderDAO.getTableNum())
                .date(computerOrderDAO.getDate())
                .userName(computerOrderDAO.getUserName())
                .phoneNum(computerOrderDAO.getPhoneNum())
                .note(computerOrderDAO.getNote())
                .totalPrice(computerOrderDAO.getTotalPrice())
                .isDeposit(computerOrderDAO.getIsDeposit())
                .isCoupon(computerOrderDAO.getIsCoupon())
                .isService(computerOrderDAO.getIsService())
                .createAt(computerOrderDAO.getCreateAt())
                .finishAt(computerOrderDAO.getFinishAt())
                .menuInfo(computerOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromElectronicsOrderDAO(ElectronicsOrderDAO electronicsOrderDAO) {
        return OrderDTO.builder()
                .orderNum(electronicsOrderDAO.getOrderNum())
                .orderId(electronicsOrderDAO.getOrderId())
                .boothId(electronicsOrderDAO.getBoothId())
                .orderType(electronicsOrderDAO.getOrderType())
                .tableNum(electronicsOrderDAO.getTableNum())
                .date(electronicsOrderDAO.getDate())
                .userName(electronicsOrderDAO.getUserName())
                .phoneNum(electronicsOrderDAO.getPhoneNum())
                .note(electronicsOrderDAO.getNote())
                .totalPrice(electronicsOrderDAO.getTotalPrice())
                .isDeposit(electronicsOrderDAO.getIsDeposit())
                .isCoupon(electronicsOrderDAO.getIsCoupon())
                .isService(electronicsOrderDAO.getIsService())
                .createAt(electronicsOrderDAO.getCreateAt())
                .finishAt(electronicsOrderDAO.getFinishAt())
                .menuInfo(electronicsOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromEnergyOrderDAO(EnergyOrderDAO energyOrderDAO) {
        return OrderDTO.builder()
                .orderNum(energyOrderDAO.getOrderNum())
                .orderId(energyOrderDAO.getOrderId())
                .boothId(energyOrderDAO.getBoothId())
                .orderType(energyOrderDAO.getOrderType())
                .tableNum(energyOrderDAO.getTableNum())
                .date(energyOrderDAO.getDate())
                .userName(energyOrderDAO.getUserName())
                .phoneNum(energyOrderDAO.getPhoneNum())
                .note(energyOrderDAO.getNote())
                .totalPrice(energyOrderDAO.getTotalPrice())
                .isDeposit(energyOrderDAO.getIsDeposit())
                .isCoupon(energyOrderDAO.getIsCoupon())
                .isService(energyOrderDAO.getIsService())
                .createAt(energyOrderDAO.getCreateAt())
                .finishAt(energyOrderDAO.getFinishAt())
                .menuInfo(energyOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromGameOrderDAO(GameOrderDAO gameOrderDAO) {
        return OrderDTO.builder()
                .orderNum(gameOrderDAO.getOrderNum())
                .orderId(gameOrderDAO.getOrderId())
                .boothId(gameOrderDAO.getBoothId())
                .orderType(gameOrderDAO.getOrderType())
                .tableNum(gameOrderDAO.getTableNum())
                .date(gameOrderDAO.getDate())
                .userName(gameOrderDAO.getUserName())
                .phoneNum(gameOrderDAO.getPhoneNum())
                .note(gameOrderDAO.getNote())
                .totalPrice(gameOrderDAO.getTotalPrice())
                .isDeposit(gameOrderDAO.getIsDeposit())
                .isCoupon(gameOrderDAO.getIsCoupon())
                .isService(gameOrderDAO.getIsService())
                .createAt(gameOrderDAO.getCreateAt())
                .finishAt(gameOrderDAO.getFinishAt())
                .menuInfo(gameOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromMachineOrderDAO(MachineOrderDAO machineOrderDAO) {
        return OrderDTO.builder()
                .orderNum(machineOrderDAO.getOrderNum())
                .orderId(machineOrderDAO.getOrderId())
                .boothId(machineOrderDAO.getBoothId())
                .orderType(machineOrderDAO.getOrderType())
                .tableNum(machineOrderDAO.getTableNum())
                .date(machineOrderDAO.getDate())
                .userName(machineOrderDAO.getUserName())
                .phoneNum(machineOrderDAO.getPhoneNum())
                .note(machineOrderDAO.getNote())
                .totalPrice(machineOrderDAO.getTotalPrice())
                .isDeposit(machineOrderDAO.getIsDeposit())
                .isCoupon(machineOrderDAO.getIsCoupon())
                .isService(machineOrderDAO.getIsService())
                .createAt(machineOrderDAO.getCreateAt())
                .finishAt(machineOrderDAO.getFinishAt())
                .menuInfo(machineOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromNanoOrderDAO(NanoOrderDAO nanoOrderDAO) {
        return OrderDTO.builder()
                .orderNum(nanoOrderDAO.getOrderNum())
                .orderId(nanoOrderDAO.getOrderId())
                .boothId(nanoOrderDAO.getBoothId())
                .orderType(nanoOrderDAO.getOrderType())
                .tableNum(nanoOrderDAO.getTableNum())
                .date(nanoOrderDAO.getDate())
                .userName(nanoOrderDAO.getUserName())
                .phoneNum(nanoOrderDAO.getPhoneNum())
                .note(nanoOrderDAO.getNote())
                .totalPrice(nanoOrderDAO.getTotalPrice())
                .isDeposit(nanoOrderDAO.getIsDeposit())
                .isCoupon(nanoOrderDAO.getIsCoupon())
                .isService(nanoOrderDAO.getIsService())
                .createAt(nanoOrderDAO.getCreateAt())
                .finishAt(nanoOrderDAO.getFinishAt())
                .menuInfo(nanoOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromNewMaterialOrderDAO(NewMaterialOrderDAO newMaterialOrderDAO) {
        return OrderDTO.builder()
                .orderNum(newMaterialOrderDAO.getOrderNum())
                .orderId(newMaterialOrderDAO.getOrderId())
                .boothId(newMaterialOrderDAO.getBoothId())
                .orderType(newMaterialOrderDAO.getOrderType())
                .tableNum(newMaterialOrderDAO.getTableNum())
                .date(newMaterialOrderDAO.getDate())
                .userName(newMaterialOrderDAO.getUserName())
                .phoneNum(newMaterialOrderDAO.getPhoneNum())
                .note(newMaterialOrderDAO.getNote())
                .totalPrice(newMaterialOrderDAO.getTotalPrice())
                .isDeposit(newMaterialOrderDAO.getIsDeposit())
                .isCoupon(newMaterialOrderDAO.getIsCoupon())
                .isService(newMaterialOrderDAO.getIsService())
                .createAt(newMaterialOrderDAO.getCreateAt())
                .finishAt(newMaterialOrderDAO.getFinishAt())
                .menuInfo(newMaterialOrderDAO.getMenuInfo())
                .build();
    }

    public static OrderDTO fromDesignOrderDAO(DesignOrderDAO designOrderDAO) {
        return OrderDTO.builder()
                .orderNum(designOrderDAO.getOrderNum())
                .orderId(designOrderDAO.getOrderId())
                .boothId(designOrderDAO.getBoothId())
                .orderType(designOrderDAO.getOrderType())
                .tableNum(designOrderDAO.getTableNum())
                .date(designOrderDAO.getDate())
                .userName(designOrderDAO.getUserName())
                .phoneNum(designOrderDAO.getPhoneNum())
                .note(designOrderDAO.getNote())
                .totalPrice(designOrderDAO.getTotalPrice())
                .isDeposit(designOrderDAO.getIsDeposit())
                .isCoupon(designOrderDAO.getIsCoupon())
                .isService(designOrderDAO.getIsService())
                .createAt(designOrderDAO.getCreateAt())
                .menuInfo(designOrderDAO.getMenuInfo())
                .build();
    }
}
