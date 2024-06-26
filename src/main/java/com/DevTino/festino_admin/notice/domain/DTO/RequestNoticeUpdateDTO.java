package com.DevTino.festino_admin.notice.domain.DTO;

import lombok.Data;
import java.util.UUID;

@Data
public class RequestNoticeUpdateDTO {

    UUID noticeId;
    String title;
    String writerName;
    String imageUrl;
    String content;

}
