package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeSaveDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateNoticeDAOBean {

    public NoticeDAO exec(RequestNoticeSaveDTO requestNoticeSaveDTO){

        // 공지 이미지를 넣지 않았을 때 빈값으로 저장
        String imageUrl = "";
        if (requestNoticeSaveDTO.getImageUrl() != null)
            imageUrl = requestNoticeSaveDTO.getImageUrl();
        
        // 공지사항 DAO 생성해서 리턴
        return NoticeDAO.builder()
                .noticeId(UUID.randomUUID())
                .title(requestNoticeSaveDTO.getTitle())
                .writerName(requestNoticeSaveDTO.getWriterName())
                .imageUrl(imageUrl)
                .content(requestNoticeSaveDTO.getContent())
                .isPin(requestNoticeSaveDTO.getIsPin())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

    }

}
