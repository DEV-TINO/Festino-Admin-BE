package com.DevTino.festino_admin.order.domain;

import com.DevTino.festino_admin.order.domain.DTO.MenuInfoDTO;
import com.DevTino.festino_admin.order.others.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AbstractOrderDAO {

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

}
