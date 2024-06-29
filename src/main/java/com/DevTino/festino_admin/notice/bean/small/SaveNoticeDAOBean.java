package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import com.DevTino.festino_admin.notice.repository.NoticeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveNoticeDAOBean {

    NoticeRepositoryJPA noticeRepositoryJPA;

    @Autowired
    public SaveNoticeDAOBean(NoticeRepositoryJPA noticeRepositoryJPA){
        this.noticeRepositoryJPA = noticeRepositoryJPA;
    }



    // 공지사항 DAO를 DB에 저장
    public void exec(NoticeDAO noticeDAO){
        noticeRepositoryJPA.save(noticeDAO);
    }

}
