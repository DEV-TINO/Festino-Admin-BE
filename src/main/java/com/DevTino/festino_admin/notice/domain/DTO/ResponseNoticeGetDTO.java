package com.DevTino.festino_admin.notice.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseNoticeGetDTO {

    UUID noticeId;
    String title;
    String writerName;
    String imageUrl;
    String content;
    Boolean isPin;
    LocalDateTime createAt;
    LocalDateTime updateAt;

}