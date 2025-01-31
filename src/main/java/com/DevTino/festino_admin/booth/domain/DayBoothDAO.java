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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayBoothDAO {
    @Id
    UUID boothId;

    String boothName;
    String adminCategory;
    String adminName;
    String openTime;
    String closeTime;
    String boothIntro;

    @Convert(converter = StringConverter.class)
    List<String> boothImage;
    Boolean isOpen;

    Integer markerNum;
    String location;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
