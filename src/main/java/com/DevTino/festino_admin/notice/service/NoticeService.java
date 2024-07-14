package com.DevTino.festino_admin.notice.service;

import com.DevTino.festino_admin.notice.bean.*;
import com.DevTino.festino_admin.notice.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoticeService {

    GetNoticeBean getNoticeBean;
    GetNoticesBean getNoticesBean;
    SaveNoticeBean saveNoticeBean;
    UpdateNoticeBean updateNoticeBean;
    UpdateNoticePinBean updateNoticePinBean;
    DeleteNoticeBean deleteNoticeBean;

    @Autowired
    public NoticeService(GetNoticeBean getNoticeBean, GetNoticesBean getNoticesBean, SaveNoticeBean saveNoticeBean, UpdateNoticeBean updateNoticeBean, UpdateNoticePinBean updateNoticePinBean, DeleteNoticeBean deleteNoticeBean){
        this.getNoticeBean = getNoticeBean;
        this.getNoticesBean = getNoticesBean;
        this.saveNoticeBean = saveNoticeBean;
        this.updateNoticeBean = updateNoticeBean;
        this.updateNoticePinBean = updateNoticePinBean;
        this.deleteNoticeBean = deleteNoticeBean;
    }



    // 공지사항 조회
    public ResponseNoticeGetDTO getNotice(UUID noticeId){

        return getNoticeBean.exec(noticeId);

    }

    // 공지사항 전체 조회
    public List<ResponseNoticeGetDTO> getNoticeAll(int pageNo){

        return getNoticesBean.exec(pageNo);

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
    public List<ResponseNoticePinUpdateDTO> updateNoticePin(List<RequestNoticePinUpdateDTO> requestNoticePinUpdateDTOList){

        return updateNoticePinBean.exec(requestNoticePinUpdateDTOList);

    }

    // 공지사항 삭제
    public boolean deleteNotice(RequestNoticeDeleteDTO requestNoticeDeleteDTO){

        return deleteNoticeBean.exec(requestNoticeDeleteDTO);

    }

}
