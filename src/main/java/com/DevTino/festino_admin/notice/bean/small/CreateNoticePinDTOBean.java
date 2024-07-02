package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticePinUpdateDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNoticePinDTOBean {

    public ResponseNoticePinUpdateDTO exec(NoticeDAO noticeDAO){

        return ResponseNoticePinUpdateDTO.builder()
                .noticeId(noticeDAO.getNoticeId())
                .isPin(noticeDAO.getIsPin())
                .build();

    }

}
