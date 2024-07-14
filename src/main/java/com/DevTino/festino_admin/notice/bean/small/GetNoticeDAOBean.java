package com.DevTino.festino_admin.notice.bean.small;

import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import com.DevTino.festino_admin.notice.repository.NoticeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

        return noticeRepositoryJPA.findById(noticeId).orElse(null);

    }



    // 공지사항 DAO pin 우선, 최신순 정렬 검색해서 page 반환
    public Page<NoticeDAO> exec(int pageNo, int PAGE_SIZE){

        // 페이지 번호와 사이즈로 Pageable 생성
        Pageable pageable = PageRequest.of(pageNo, PAGE_SIZE);

        // pin 우선, 최신순 정렬 검색해서 반환
        return noticeRepositoryJPA.findAllByOrderByIsPinDescCreateAtDesc(pageable);

    }



    // 공지사항 전체 검색
    public List<NoticeDAO> exec(){

        return noticeRepositoryJPA.findAll();

    }

}
