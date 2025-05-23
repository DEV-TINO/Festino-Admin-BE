package com.DevTino.festino_admin.order.domain;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
@SuperBuilder
public class BiochemistryOrderDAO extends AbstractOrderDAO{

    public static BiochemistryOrderDAO fromOrderDTO(OrderDTO orderDTO) {
        return BiochemistryOrderDAO.builder()
                .orderNum(orderDTO.getOrderNum())
                .orderId(orderDTO.getOrderId())
                .boothId(orderDTO.getBoothId())
                .orderType(orderDTO.getOrderType())
                .tableNum(orderDTO.getTableNum())
                .date(orderDTO.getDate())
                .userName(orderDTO.getUserName())
                .phoneNum(orderDTO.getPhoneNum())
                .note(orderDTO.getNote())
                .totalPrice(orderDTO.getTotalPrice())
                .isDeposit(orderDTO.getIsDeposit())
                .isCoupon(orderDTO.getIsCoupon())
                .isService(orderDTO.getIsService())
                .createAt(orderDTO.getCreateAt())
                .finishAt(orderDTO.getFinishAt())
                .menuInfo(orderDTO.getMenuInfo())
                .build();
    }
}
