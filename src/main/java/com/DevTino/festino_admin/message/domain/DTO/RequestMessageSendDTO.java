package com.DevTino.festino_admin.message.domain.DTO;

import lombok.Data;

@Data
public class RequestMessageSendDTO {
    String phoneNum;
    String userName;
    String adminName;
    String message;
}
