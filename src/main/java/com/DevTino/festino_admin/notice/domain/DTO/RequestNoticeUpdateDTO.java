package com.DevTino.festino_admin.notice.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RequestNoticeUpdateDTO {

    UUID noticeId;
    String title;
    String writerName;
    List<String> imageUrl;
    String content;
    Boolean isPin;

}
