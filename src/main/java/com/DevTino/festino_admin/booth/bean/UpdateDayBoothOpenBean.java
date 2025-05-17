package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateDayBoothOpenDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetDayBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveDayBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestDayBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateDayBoothOpenBean {
    GetDayBoothDAOBean getDayBoothDAOBean;
    SaveDayBoothDAOBean saveDayBoothDAOBean;
    CreateDayBoothOpenDTOBean createDayBoothOpenDTOBean;

    @Autowired
    public UpdateDayBoothOpenBean(GetDayBoothDAOBean getDayBoothDAOBean, SaveDayBoothDAOBean saveDayBoothDAOBean, CreateDayBoothOpenDTOBean createDayBoothOpenDTOBean) {
        this.getDayBoothDAOBean = getDayBoothDAOBean;
        this.saveDayBoothDAOBean = saveDayBoothDAOBean;
        this.createDayBoothOpenDTOBean = createDayBoothOpenDTOBean;
    }

    // 주간부스 운영 중 여부 수정
    public ResponseDayBoothOpenUpdateDTO exec(RequestDayBoothOpenUpdateDTO requestDayBoothOpenUpdateDTO) {
        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        DayBoothDAO dayBoothDAO = getDayBoothDAOBean.exec(requestDayBoothOpenUpdateDTO.getBoothId());

        // 부스 운영중 여부와 입력값이 다른 경우 예외 발생
        if(dayBoothDAO.getIsOpen() != requestDayBoothOpenUpdateDTO.getIsOpen()) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // DAO 수정
        dayBoothDAO.setIsOpen(!dayBoothDAO.getIsOpen());

        // DAO 저장
        saveDayBoothDAOBean.exec(dayBoothDAO);

        // DTO 생성해서 반환
        return createDayBoothOpenDTOBean.exec(dayBoothDAO);
    }
}
