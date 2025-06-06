package com.DevTino.festino_admin.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TableNumDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long tableNumId;
    UUID boothId;
    Integer tableNumIndex;
    String customTableNum;
    String orderUrl;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
