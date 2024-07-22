package com.DevTino.festino_admin.menu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDAO {
    @Id
    UUID menuId;

    UUID boothId;
    String menuName;
    Integer menuPrice;
    String menuDescription;
    String menuImage;
    Boolean isSoldOut;
    Boolean isDeleted;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    MenuType menuType;
}
