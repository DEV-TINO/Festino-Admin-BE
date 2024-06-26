package com.DevTino.festino_admin.notice.bean.small;


import com.DevTino.festino_admin.notice.bean.DeleteNoticeBean;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import com.DevTino.festino_admin.notice.repository.NoticeRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class DeleteNoticeDAOBean {

    NoticeRepositoryJPA noticeRepositoryJPA;

    public DeleteNoticeDAOBean(NoticeRepositoryJPA noticeRepositoryJPA){
        this.noticeRepositoryJPA = noticeRepositoryJPA;
    }



    // 공지사항 DAO를 DB에서 삭제
    public void exec(NoticeDAO noticeDAO){

        noticeRepositoryJPA.delete(noticeDAO);

    }

}
