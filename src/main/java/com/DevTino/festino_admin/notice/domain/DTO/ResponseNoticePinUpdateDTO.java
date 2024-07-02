package com.DevTino.festino_admin.notice.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseNoticePinUpdateDTO {

    UUID noticeId;
    Boolean isPin;

}