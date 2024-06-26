package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.bean.small.SaveNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeUpdateDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateNoticeBean {

    GetNoticeDAOBean getNoticeDAOBean;
    SaveNoticeDAOBean saveNoticeDAOBean;

    @Autowired
    public UpdateNoticeBean(GetNoticeDAOBean getNoticeDAOBean, SaveNoticeDAOBean saveNoticeDAOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
        this.saveNoticeDAOBean = saveNoticeDAOBean;
    }



    // 공지사항 수정
    public UUID exec(RequestNoticeUpdateDTO requestNoticeUpdateDTO){

        // noticeId로 해당 Notice DAO 찾기
        NoticeDAO noticeDAO = getNoticeDAOBean.exec(requestNoticeUpdateDTO.getNoticeId());
        if (noticeDAO == null) return null;

        // DAO 수정
        noticeDAO.setTitle(requestNoticeUpdateDTO.getTitle());
        noticeDAO.setWriterName(requestNoticeUpdateDTO.getWriterName());
        noticeDAO.setImageUrl(requestNoticeUpdateDTO.getImageUrl());
        noticeDAO.setContent(requestNoticeUpdateDTO.getContent());

        // DAO 수정 : 수정 시간 저장
        noticeDAO.setUpdateAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveNoticeDAOBean.exec(noticeDAO);

        // 수정된 DAO의 noticeId 반환
        return noticeDAO.getNoticeId();

    }

}
