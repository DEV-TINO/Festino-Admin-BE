package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateNoticesDTOBean {

    public List<ResponseNoticeGetDTO> exec(Page<NoticeDAO> page){

        // DTO 리스트 생성
        List<ResponseNoticeGetDTO> noticeDTOList = new ArrayList<>();

        // DAO 리스트에서 DAO 하나씩 꺼내서
        for (NoticeDAO noticeDAO : page){

            // DTO 생성 -> DAO 값으로 설정
            ResponseNoticeGetDTO dto = ResponseNoticeGetDTO.builder()
                    .noticeId(noticeDAO.getNoticeId())
                    .title(noticeDAO.getTitle())
                    .writerName(noticeDAO.getWriterName())
                    .imageUrl(noticeDAO.getImageUrl())
                    .content(noticeDAO.getContent())
                    .isPin(noticeDAO.getIsPin())
                    .updateAt(noticeDAO.getUpdateAt())
                    .build();

            // 생성한 DTO를 DTO 리스트에 삽입
            noticeDTOList.add(dto);

        }

        // 생성한 DTO 리스트 리턴
        return noticeDTOList;
    }
}
