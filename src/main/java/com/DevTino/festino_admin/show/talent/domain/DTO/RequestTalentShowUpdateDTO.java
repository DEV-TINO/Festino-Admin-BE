package com.DevTino.festino_admin.show.talent.domain.DTO;

import com.DevTino.festino_admin.show.talent.others.StringListConverter;
import jakarta.persistence.Convert;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class RequestTalentShowUpdateDTO {

    UUID talentId;
    String talentName;
    String talentImage;
    String showDate;
    String showStartTime;
    String showEndTime;

    @Convert(converter = StringListConverter.class)
    List<Map<String, Object>> musicList;

}
