package com.DevTino.festino_admin.show.talent.domain.DTO;

import com.DevTino.festino_admin.show.talent.others.StringListConverter;
import jakarta.persistence.Convert;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ResponseTalentShowGetDTO {


    UUID talentId;
    String talentName;
    String talentImage;
    String showDate;
    String showStartTime;
    String showEndTime;
    Boolean isShowing;
    List<Map<String, Object>> musicList;


}
