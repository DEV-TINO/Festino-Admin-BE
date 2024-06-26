package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetNoticeBean {

    GetNoticeDAOBean getNoticeDAOBean;

    @Autowired
    public GetNoticeBean(GetNoticeDAOBean getNoticeDAOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
    }



    // 공지사항 조회
    public ResponseNoticeGetDTO exec(UUID noticeId){

        // noticeId로 해당 Notice DAO 찾기
        NoticeDAO noticeDAO = getNoticeDAOBean.exec(noticeId);
        if (noticeDAO == null) return null;

        // DTO 생성해서 반환
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
