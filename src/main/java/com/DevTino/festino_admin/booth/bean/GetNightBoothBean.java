package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetNightBoothBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    CreateNightBoothDTOBean createNightBoothDTOBean;

    @Autowired
    public GetNightBoothBean(GetNightBoothDAOBean getNightBoothDAOBean, CreateNightBoothDTOBean createNightBoothDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.createNightBoothDTOBean = createNightBoothDTOBean;
    }

    public ResponseNightBoothGetDTO exec(UUID boothId) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(boothId);

        // DTO 생성해서 반환
        return createNightBoothDTOBean.exec(nightBoothDAO);
    }
}
