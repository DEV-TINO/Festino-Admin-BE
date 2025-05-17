package com.DevTino.festino_admin.notice.bean;

import com.DevTino.festino_admin.notice.bean.small.CreateNoticePinDTOBean;
import com.DevTino.festino_admin.notice.bean.small.GetNoticeDAOBean;
import com.DevTino.festino_admin.notice.bean.small.SaveNoticeDAOBean;
import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticePinUpdateDTO;
import com.DevTino.festino_admin.notice.domain.DTO.ResponseNoticePinUpdateDTO;
import com.DevTino.festino_admin.notice.domain.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateNoticePinBean {

    GetNoticeDAOBean getNoticeDAOBean;
    SaveNoticeDAOBean saveNoticeDAOBean;
    CreateNoticePinDTOBean createNoticePinDTOBean;

    @Autowired
    public UpdateNoticePinBean(GetNoticeDAOBean getNoticeDAOBean, SaveNoticeDAOBean saveNoticeDAOBean, CreateNoticePinDTOBean createNoticePinDTOBean){
        this.getNoticeDAOBean = getNoticeDAOBean;
        this.saveNoticeDAOBean = saveNoticeDAOBean;
        this.createNoticePinDTOBean = createNoticePinDTOBean;
    }



    // 공지사항 pin 수정
    public List<ResponseNoticePinUpdateDTO> exec(List<RequestNoticePinUpdateDTO> requestNoticePinUpdateDTOList){

        // 반환할 Response DTO List 생성
        List<ResponseNoticePinUpdateDTO> responseNoticePinUpdateDTOList = new ArrayList<>();

        // Request DTO List에서 하나씩 꺼내서 작업
        for (RequestNoticePinUpdateDTO requestNoticePinUpdateDTO : requestNoticePinUpdateDTOList){

            // noticeId로 해당 Notice DAO 찾기
            NoticeDAO noticeDAO = getNoticeDAOBean.exec(requestNoticePinUpdateDTO.getNoticeId());

            // DTO pin 값과 DAO pin 값 비교해서 같을 경우만 DAO pin 수정
            if (requestNoticePinUpdateDTO.getIsPin() == noticeDAO.getIsPin()) {

                // DAO의 pin 수정
                noticeDAO.setIsPin(!noticeDAO.getIsPin());

                // 수정된 DAO 저장
                saveNoticeDAOBean.exec(noticeDAO);

            }

            // DTO 생성해 DTO List에 추가
            responseNoticePinUpdateDTOList.add(createNoticePinDTOBean.exec(noticeDAO));

        }

        // 생성된 DTO List 반환
        return responseNoticePinUpdateDTOList;

    }
}
