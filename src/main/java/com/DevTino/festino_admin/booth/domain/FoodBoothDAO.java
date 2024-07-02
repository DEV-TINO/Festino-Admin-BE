package com.DevTino.festino_admin.booth.domain;

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
public class FoodBoothDAO {
    @Id
    UUID boothId;

    String adminName;
    String adminCategory;
    String boothName;
    String openTime;
    String closeTime;
    String boothIntro;
    String boothImage;
    String location;
    Boolean isOpen;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
