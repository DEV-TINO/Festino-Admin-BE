package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.notice.bean.small.CreateNoticePinDTOBean;
import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.bean.small.SaveNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticePinUpdateDTO;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeUpdateDTO;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticePinUpdateDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        // 공지 이미지를 넣지 않았을 때 빈값으로 저장
        List<String> imageUrl;
        if (requestNoticeUpdateDTO.getImageUrl() == null)
            imageUrl = Collections.singletonList("");
        else
            imageUrl = requestNoticeUpdateDTO.getImageUrl();

        // DAO 수정
        noticeDAO.setTitle(requestNoticeUpdateDTO.getTitle());
        noticeDAO.setWriterName(requestNoticeUpdateDTO.getWriterName());
        noticeDAO.setImageUrl(imageUrl);
        noticeDAO.setContent(requestNoticeUpdateDTO.getContent());
        noticeDAO.setIsPin(requestNoticeUpdateDTO.getIsPin());

        // DAO 수정 : 수정 시간 저장
        noticeDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정된 DAO 저장
        saveNoticeDAOBean.exec(noticeDAO);

        // 수정된 DAO의 noticeId 반환
        return noticeDAO.getNoticeId();

    }

}
