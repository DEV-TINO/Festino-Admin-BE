package com.DevTino.festino_admin.show.club.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestClubShowUpdateDTO {

    UUID clubId;
    String clubName;
    String showDate;
    String showStartTime;
    String showEndTime;
    String clubImage;

}
