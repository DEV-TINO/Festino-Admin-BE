package com.DevTino.festino_admin.show.club.damain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseClubShowGetDTO {

    UUID clubId;
    String clubName;
    String showDate;
    String showStartTime;
    String showEndTime;
    String clubImage;

}
