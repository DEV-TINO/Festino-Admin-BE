package com.DevTino.festino_admin.notice.domain.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class RequestNoticeSaveDTO {
    
    String title;
    String writerName;
    List<String> imageUrl;
    String content;
    Boolean isPin;

}
