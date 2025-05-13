package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.CreateNoticeDAOBean;
import com.DevTino.festino_admin.notice.bean.small.SaveNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeSaveDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveNoticeBean {

    CreateNoticeDAOBean createNoticeDAOBean;
    SaveNoticeDAOBean saveNoticeDAOBean;

    @Autowired
    public SaveNoticeBean(CreateNoticeDAOBean createNoticeDAOBean, SaveNoticeDAOBean saveNoticeDAOBean){
        this.createNoticeDAOBean = createNoticeDAOBean;
        this.saveNoticeDAOBean = saveNoticeDAOBean;
    }



    // 공지사항 저장
    public UUID exec(RequestNoticeSaveDTO requestNoticeSaveDTO){

        // 공지사항 DAO 객체 생성
        NoticeDAO noticeDAO = createNoticeDAOBean.exec(requestNoticeSaveDTO);

        // DAO 저장
        saveNoticeDAOBean.exec(noticeDAO);

        // DAO의 PK 리턴
        return noticeDAO.getNoticeId();

    }

}
