package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateNoticeDTOBean {

    public ResponseNoticeGetDTO exec(NoticeDAO noticeDAO){

        // DAO 값으로 설정한 DTO 생성해서 반환
        return ResponseNoticeGetDTO.builder()
                .noticeId(noticeDAO.getNoticeId())
                .title(noticeDAO.getTitle())
                .writerName(noticeDAO.getWriterName())
                .imageUrl(noticeDAO.getImageUrl())
                .content(noticeDAO.getContent())
                .isPin(noticeDAO.getIsPin())
                .createAt(noticeDAO.getCreateAt())
                .updateAt(noticeDAO.getUpdateAt())
                .build();
    }
}
