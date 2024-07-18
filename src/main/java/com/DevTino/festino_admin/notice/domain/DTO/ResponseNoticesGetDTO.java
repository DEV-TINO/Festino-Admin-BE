package com.DevTino.festino_admin.notice.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseNoticesGetDTO {

    Integer noticeTotal;
    List<ResponseNoticeGetDTO> noticeList;

}
