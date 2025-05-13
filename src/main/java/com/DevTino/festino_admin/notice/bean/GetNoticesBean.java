package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.CreateNoticesDTOBean;
import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticesGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetNoticesBean {

    private static final int PAGE_SIZE = 5;

    GetNoticeDAOBean getNoticeDAOBean;
    CreateNoticesDTOBean createNoticesDTOBean;

    @Autowired
    public GetNoticesBean(GetNoticeDAOBean getNoticeDAOBean, CreateNoticesDTOBean createNoticesDTOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
        this.createNoticesDTOBean = createNoticesDTOBean;
    }



    // 공지사항 전체 조회
    public ResponseNoticesGetDTO exec(int pageNo){

        // 공지사항 DAO pin 우선, 최신순 정렬 검색
        Page<NoticeDAO> page = getNoticeDAOBean.exec(pageNo, PAGE_SIZE);

        // 공지사항 전체 개수
        Integer noticeTotal = getNoticeDAOBean.exec().size();

        // DTO 생성해서 반환
        return createNoticesDTOBean.exec(page, noticeTotal);

    }

}
