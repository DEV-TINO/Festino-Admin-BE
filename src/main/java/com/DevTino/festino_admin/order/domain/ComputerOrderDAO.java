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
public class ComputerOrderDAO {
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
    String note;
    Integer totalPrice;
    Boolean isDeposit;
    Boolean isCoupon;
    Boolean isService;
    LocalDateTime createAt;
    LocalDateTime finishAt;

    @Convert(converter = StringListConverter.class)
    List<MenuInfoDTO> menuInfo;

    public static ComputerOrderDAO fromOrderDTO(OrderDTO orderDTO) {
        return ComputerOrderDAO.builder()
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
