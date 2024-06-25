package com.DevTino.festino_admin.notice.service;

import com.DevTino.festino_admin.notice.bean.SaveNoticeBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoticeService {

    SaveNoticeBean saveNoticeBean;

    @Autowired
    public NoticeService(SaveNoticeBean saveNoticeBean){
        this.saveNoticeBean = saveNoticeBean;
    }



    // 공지사항 저장
    public UUID saveNotice(RequestNoticeSaveDTO requestNoticeSaveDTO){

        return saveNoticeBean.exec(requestNoticeSaveDTO);

    }

}
