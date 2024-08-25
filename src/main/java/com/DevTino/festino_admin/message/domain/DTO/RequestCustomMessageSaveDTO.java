package com.DevTino.festino_admin.message.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RequestCustomMessageSaveDTO {
    UUID boothId;
    List<CustomMessageDTO> customMessageList;
}
