package com.DevTino.festino_admin.show.talent.domain;

import com.DevTino.festino_admin.show.talent.others.StringListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TalentShowDAO {

    @Id
    UUID talentId;
    String talentName;
    String talentImage;
    String showDate;
    String showStartTime;
    String showEndTime;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    @Convert(converter = StringListConverter.class)
    List<Map<String, Object>> musicList;

}
