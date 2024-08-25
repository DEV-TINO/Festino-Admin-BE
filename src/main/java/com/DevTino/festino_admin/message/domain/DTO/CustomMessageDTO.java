package com.DevTino.festino_admin.message.domain.DTO;

import com.DevTino.festino_admin.message.domain.ENUM.MessageType;
import lombok.Data;

@Data
public class CustomMessageDTO {
    String message;
    MessageType messageType;
}
