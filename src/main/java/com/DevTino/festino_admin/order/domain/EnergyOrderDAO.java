package com.DevTino.festino_admin.order.domain;

import com.DevTino.festino_admin.order.domain.DTO.MenuInfoDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.others.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EnergyOrderDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Convert(converter = StringListConverter.class)
    List<MenuInfoDTO> menuInfo;

    public static EnergyOrderDAO fromOrderDTO(OrderDTO orderDTO) {
        return EnergyOrderDAO.builder()
                .orderNum(orderDTO.getOrderNum())
                .orderId(orderDTO.getOrderId())
                .boothId(orderDTO.getBoothId())
                .orderType(orderDTO.getOrderType())
                .tableNum(orderDTO.getTableNum())
                .date(orderDTO.getOrderNum())
                .userName(orderDTO.getUserName())
                .phoneNum(orderDTO.getPhoneNum())
                .totalPrice(orderDTO.getTotalPrice())
                .isDeposit(orderDTO.getIsDeposit())
                .isCoupon(orderDTO.getIsCoupon())
                .createAt(orderDTO.getCreateAt())
                .menuInfo(orderDTO.getMenuInfo())
                .build();
    }
}
