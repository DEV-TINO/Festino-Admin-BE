package com.DevTino.festino_admin.order.domain;

import com.DevTino.festino_admin.order.others.StringListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDAO {

    @Id
    UUID orderId;
    OrderType orderType;
    Integer tableNum;
    String name;
    String phoneNum;

    @Convert(converter = StringListConverter.class)
    List<Map<String, Object>> cookInfo;

    Integer totalPrice;
    Boolean isDeposit;
    Boolean isCoupon;
    Boolean isDeleted;
    LocalDateTime createAt;


}
