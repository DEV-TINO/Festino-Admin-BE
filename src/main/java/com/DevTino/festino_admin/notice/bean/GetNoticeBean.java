package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.CreateNoticeDTOBean;
import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetNoticeBean {

    GetNoticeDAOBean getNoticeDAOBean;
    CreateNoticeDTOBean createNoticeDTOBean;

    @Autowired
    public GetNoticeBean(GetNoticeDAOBean getNoticeDAOBean, CreateNoticeDTOBean createNoticeDTOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
        this.createNoticeDTOBean = createNoticeDTOBean;
    }



    // 공지사항 조회
    public ResponseNoticeGetDTO exec(UUID noticeId){

        // noticeId로 해당 Notice DAO 찾기
        NoticeDAO noticeDAO = getNoticeDAOBean.exec(noticeId);
        if (noticeDAO == null) return null;

        // DTO 생성해서 반환
        return createNoticeDTOBean.exec(noticeDAO);

    }

}
