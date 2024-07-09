package com.DevTino.festino_admin.show.club.domain.DTO;

import lombok.Data;

@Data
public class RequestClubShowSaveDTO {

    String clubName;
    String showDate;
    String showStartTime;
    String showEndTime;
    String clubImage;

}
