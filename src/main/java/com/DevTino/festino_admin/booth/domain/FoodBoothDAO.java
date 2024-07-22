package com.DevTino.festino_admin.booth.domain;

import com.DevTino.festino_admin.booth.others.StringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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

    @Convert(converter = StringConverter.class)
    List<String> boothImage;
    Boolean isOpen;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
