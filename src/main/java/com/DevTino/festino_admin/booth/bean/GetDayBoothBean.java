package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateDayBoothDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetDayBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDayBoothBean {
    GetDayBoothDAOBean getDayBoothDAOBean;
    CreateDayBoothDTOBean createDayBoothDTOBean;

    @Autowired
    public GetDayBoothBean(GetDayBoothDAOBean getDayBoothDAOBean, CreateDayBoothDTOBean createDayBoothDTOBean) {
        this.getDayBoothDAOBean = getDayBoothDAOBean;
        this.createDayBoothDTOBean = createDayBoothDTOBean;
    }

    public ResponseDayBoothGetDTO exec(UUID boothId) {
        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        DayBoothDAO dayBoothDAO = getDayBoothDAOBean.exec(boothId);

        // DTO 생성해서 반환
        return createDayBoothDTOBean.exec(dayBoothDAO);
    }
}
