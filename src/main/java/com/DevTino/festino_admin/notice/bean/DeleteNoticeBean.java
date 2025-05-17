package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.DeleteNoticeDAOBean;
import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeDeleteDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteNoticeBean {

    GetNoticeDAOBean getNoticeDAOBean;
    DeleteNoticeDAOBean deleteNoticeDAOBean;

    @Autowired
    public DeleteNoticeBean(GetNoticeDAOBean getNoticeDAOBean, DeleteNoticeDAOBean deleteNoticeDAOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
        this.deleteNoticeDAOBean = deleteNoticeDAOBean;
    }

    // 공지사항 삭제
    public void exec(RequestNoticeDeleteDTO requestNoticeDeleteDTO){

        // noticeId로 해당 Notice DAO 찾기
        NoticeDAO noticeDAO = getNoticeDAOBean.exec(requestNoticeDeleteDTO.getNoticeId());

        // DAO 삭제
        deleteNoticeDAOBean.exec(noticeDAO);

    }

}
