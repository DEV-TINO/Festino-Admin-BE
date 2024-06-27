package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import com.DevTino.festino_admin.notice.repository.NoticeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetNoticeDAOBean {

    NoticeRepositoryJPA noticeRepositoryJPA;

    @Autowired
    public GetNoticeDAOBean(NoticeRepositoryJPA noticeRepositoryJPA){
        this.noticeRepositoryJPA = noticeRepositoryJPA;
    }



    // noticeId로 DAO 찾아서 반환
    public NoticeDAO exec(UUID noticeId){

        return noticeRepositoryJPA.findById(noticeId).get();

    }

    // 공지사항 DAO 전체 검색해서 반환
    public List<NoticeDAO> exec(){

        return noticeRepositoryJPA.findAll();

    }

}
