package com.DevTino.festino_admin.notice.service;

import com.DevTino.festino_admin.notice.bean.DeleteNoticeBean;
import com.DevTino.festino_admin.notice.bean.GetNoticeBean;
import com.DevTino.festino_admin.notice.bean.SaveNoticeBean;
import com.DevTino.festino_admin.notice.bean.UpdateNoticeBean;
import com.DevTino.festino_admin.notice.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoticeService {

    GetNoticeBean getNoticeBean;
    SaveNoticeBean saveNoticeBean;
    UpdateNoticeBean updateNoticeBean;
    DeleteNoticeBean deleteNoticeBean;

    @Autowired
    public NoticeService(GetNoticeBean getNoticeBean, SaveNoticeBean saveNoticeBean, UpdateNoticeBean updateNoticeBean, DeleteNoticeBean deleteNoticeBean){
        this.getNoticeBean = getNoticeBean;
        this.saveNoticeBean = saveNoticeBean;
        this.updateNoticeBean = updateNoticeBean;
        this.deleteNoticeBean = deleteNoticeBean;
    }



    // 공지사항 조회
    public ResponseNoticeGetDTO getNotice(UUID noticeId){

        return getNoticeBean.exec(noticeId);

    }

    // 공지사항 저장
    public UUID saveNotice(RequestNoticeSaveDTO requestNoticeSaveDTO){

        return saveNoticeBean.exec(requestNoticeSaveDTO);

    }

    // 공지사항 수정
    public UUID updateNotice(RequestNoticeUpdateDTO requestNoticeUpdateDTO){

        return updateNoticeBean.exec(requestNoticeUpdateDTO);

    }

    // 공지사항 pin 수정
    public UUID updateNoticePin(RequestNoticePinUpdateDTO requestNoticePinUpdateDTO){

        return updateNoticeBean.exec(requestNoticePinUpdateDTO);

    }

    // 공지사항 삭제
    public boolean deleteNotice(RequestNoticeDeleteDTO requestNoticeDeleteDTO){

        return deleteNoticeBean.exec(requestNoticeDeleteDTO);

    }

}
