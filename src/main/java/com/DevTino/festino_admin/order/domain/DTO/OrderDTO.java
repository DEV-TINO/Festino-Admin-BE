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
    Integer totalPrice;
    Boolean isDeposit;
    Boolean isCoupon;
    LocalDateTime createAt;
    List<MenuInfoDTO> menuInfo;

    public static OrderDTO fromComputerOrderDAO(ComputerOrderDAO computerOrderDAO) {
        return OrderDTO.builder()
                .orderNum(computerOrderDAO.getOrderNum())
                .orderId(computerOrderDAO.getOrderId())
                .boothId(computerOrderDAO.getBoothId())
                .orderType(computerOrderDAO.getOrderType())
                .tableNum(computerOrderDAO.getTableNum())
                .date(computerOrderDAO.getOrderNum())
                .userName(computerOrderDAO.getUserName())
                .phoneNum(computerOrderDAO.getPhoneNum())
                .totalPrice(computerOrderDAO.getTotalPrice())
                .isDeposit(computerOrderDAO.getIsDeposit())
                .isCoupon(computerOrderDAO.getIsCoupon())
                .createAt(computerOrderDAO.getCreateAt())
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
                .date(electronicsOrderDAO.getOrderNum())
                .userName(electronicsOrderDAO.getUserName())
                .phoneNum(electronicsOrderDAO.getPhoneNum())
                .totalPrice(electronicsOrderDAO.getTotalPrice())
                .isDeposit(electronicsOrderDAO.getIsDeposit())
                .isCoupon(electronicsOrderDAO.getIsCoupon())
                .createAt(electronicsOrderDAO.getCreateAt())
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
                .date(energyOrderDAO.getOrderNum())
                .userName(energyOrderDAO.getUserName())
                .phoneNum(energyOrderDAO.getPhoneNum())
                .totalPrice(energyOrderDAO.getTotalPrice())
                .isDeposit(energyOrderDAO.getIsDeposit())
                .isCoupon(energyOrderDAO.getIsCoupon())
                .createAt(energyOrderDAO.getCreateAt())
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
                .date(gameOrderDAO.getOrderNum())
                .userName(gameOrderDAO.getUserName())
                .phoneNum(gameOrderDAO.getPhoneNum())
                .totalPrice(gameOrderDAO.getTotalPrice())
                .isDeposit(gameOrderDAO.getIsDeposit())
                .isCoupon(gameOrderDAO.getIsCoupon())
                .createAt(gameOrderDAO.getCreateAt())
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
                .date(machineOrderDAO.getOrderNum())
                .userName(machineOrderDAO.getUserName())
                .phoneNum(machineOrderDAO.getPhoneNum())
                .totalPrice(machineOrderDAO.getTotalPrice())
                .isDeposit(machineOrderDAO.getIsDeposit())
                .isCoupon(machineOrderDAO.getIsCoupon())
                .createAt(machineOrderDAO.getCreateAt())
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
                .date(nanoOrderDAO.getOrderNum())
                .userName(nanoOrderDAO.getUserName())
                .phoneNum(nanoOrderDAO.getPhoneNum())
                .totalPrice(nanoOrderDAO.getTotalPrice())
                .isDeposit(nanoOrderDAO.getIsDeposit())
                .isCoupon(nanoOrderDAO.getIsCoupon())
                .createAt(nanoOrderDAO.getCreateAt())
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
                .date(newMaterialOrderDAO.getOrderNum())
                .userName(newMaterialOrderDAO.getUserName())
                .phoneNum(newMaterialOrderDAO.getPhoneNum())
                .totalPrice(newMaterialOrderDAO.getTotalPrice())
                .isDeposit(newMaterialOrderDAO.getIsDeposit())
                .isCoupon(newMaterialOrderDAO.getIsCoupon())
                .createAt(newMaterialOrderDAO.getCreateAt())
                .menuInfo(newMaterialOrderDAO.getMenuInfo())
                .build();
    }
}
