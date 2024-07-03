package com.DevTino.festino_admin.show.talent.domain.DTO;

import com.DevTino.festino_admin.show.talent.others.StringListConverter;
import jakarta.persistence.Convert;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestTalentShowSaveDTO {

    String talentName;
    String talentImage;
    String showDate;
    String showStartTime;
    String showEndTime;

    @Convert(converter = StringListConverter.class)
    List<Map<String, Object>> musicList;

}
