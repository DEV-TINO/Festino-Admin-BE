package com.DevTino.festino_admin.order.domain;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AbstractCookDAO {

    @Id
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

}
