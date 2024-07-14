package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticesGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateNoticesDTOBean {

    // 공지사항 전체 조회 DTO 생성
    public ResponseNoticesGetDTO exec(Page<NoticeDAO> page, Integer noticeTotal){

        // NoticeDTO 리스트 생성
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

        // NoticesDTO 생성 및 값 설정 후 반환
        return ResponseNoticesGetDTO.builder()
                .noticeTotal(noticeTotal)
                .noticeList(noticeDTOList)
                .build();

    }
}
