package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.CreateNoticesDTOBean;
import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetNoticesBean {

    GetNoticeDAOBean getNoticeDAOBean;
    CreateNoticesDTOBean createNoticesDTOBean;

    @Autowired
    public GetNoticesBean(GetNoticeDAOBean getNoticeDAOBean, CreateNoticesDTOBean createNoticesDTOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
        this.createNoticesDTOBean = createNoticesDTOBean;
    }



    // 공지사항 전체 조회
    public List<ResponseNoticeGetDTO> exec(){

        // 공지사항 DAO 전체 검색 -> noticeDAOList
        List<NoticeDAO> noticeDAOList = getNoticeDAOBean.exec();
        if (noticeDAOList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해서 리턴
        return createNoticesDTOBean.exec(noticeDAOList);

    }

}
