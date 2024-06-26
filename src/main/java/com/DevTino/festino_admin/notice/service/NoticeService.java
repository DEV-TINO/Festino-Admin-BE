package com.DevTino.festino_admin.notice.service;

import com.DevTino.festino_admin.notice.bean.DeleteNoticeBean;
import com.DevTino.festino_admin.notice.bean.SaveNoticeBean;
import com.DevTino.festino_admin.notice.bean.UpdateNoticeBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeDeleteDTO;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeSaveDTO;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoticeService {

    SaveNoticeBean saveNoticeBean;
    UpdateNoticeBean updateNoticeBean;
    DeleteNoticeBean deleteNoticeBean;

    @Autowired
    public NoticeService(SaveNoticeBean saveNoticeBean, UpdateNoticeBean updateNoticeBean, DeleteNoticeBean deleteNoticeBean){
        this.saveNoticeBean = saveNoticeBean;
        this.updateNoticeBean = updateNoticeBean;
        this.deleteNoticeBean = deleteNoticeBean;
    }



    // 공지사항 저장
    public UUID saveNotice(RequestNoticeSaveDTO requestNoticeSaveDTO){

        return saveNoticeBean.exec(requestNoticeSaveDTO);

    }

    // 공지사항 수정
    public UUID updateNotice(RequestNoticeUpdateDTO requestNoticeUpdateDTO){

        return updateNoticeBean.exec(requestNoticeUpdateDTO);

    }

    // 공지사항 삭제
    public boolean deleteNotice(RequestNoticeDeleteDTO requestNoticeDeleteDTO){

        return deleteNoticeBean.exec(requestNoticeDeleteDTO);

    }

}
