package com.DevTino.festino_admin.message.domain.DTO;

import com.DevTino.festino_admin.message.domain.ENUM.MessageType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseCustomMessageGetDTO {
    UUID boothId;
    String message;
    Integer messageType;
}
