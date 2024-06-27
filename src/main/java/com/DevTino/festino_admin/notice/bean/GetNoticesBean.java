package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticeGetDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetNoticesBean {

    GetNoticeDAOBean getNoticeDAOBean;

    @Autowired
    public GetNoticesBean(GetNoticeDAOBean getNoticeDAOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
    }



    // 공지사항 전체 조회
    public List<ResponseNoticeGetDTO> exec(){

        // 공지사항 DAO 전체 검색 -> daoList
        List<NoticeDAO> daoList = getNoticeDAOBean.exec();
        if (daoList == null) return null;

        // dtoList 생성
        List<ResponseNoticeGetDTO> dtoList = new ArrayList<>();

        // daoList에서 DAO 하나씩 꺼내서
        for (NoticeDAO noticeDAO : daoList){

            // DTO 생성 -> DAO 값으로 설정
            ResponseNoticeGetDTO dto = ResponseNoticeGetDTO.builder()
                    .noticeId(noticeDAO.getNoticeId())
                    .title(noticeDAO.getTitle())
                    .writerName(noticeDAO.getWriterName())
                    .imageUrl(noticeDAO.getImageUrl())
                    .content(noticeDAO.getContent())
                    .isPin(noticeDAO.getIsPin())
                    .createAt(noticeDAO.getCreateAt())
                    .updateAt(noticeDAO.getUpdateAt())
                    .build();

            // 생성한 DTO를 dtoList에 삽입
            dtoList.add(dto);

        }

        // 생성된 dtoList 반환
        return dtoList;
    }

}
