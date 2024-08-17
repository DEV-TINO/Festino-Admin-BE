package com.DevTino.festino_admin.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CookDAO {

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


}
