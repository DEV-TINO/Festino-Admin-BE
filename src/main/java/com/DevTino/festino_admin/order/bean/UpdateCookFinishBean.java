package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateCookFinishUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetCookDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveCookDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateCookFinishBean {

    GetCookDAOBean getCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    CreateCookFinishUpdateDTOBean createCookFinishUpdateDTOBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateCookFinishBean(GetCookDAOBean getCookDAOBean, SaveCookDAOBean saveCookDAOBean, CreateCookFinishUpdateDTOBean createCookFinishUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getCookDAOBean = getCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.createCookFinishUpdateDTOBean = createCookFinishUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // Cook 조리 완료
    public ResponseCookFinishUpdateDTO exec(UUID boothId, RequestCookFinishUpdateDTO requestCookFinishUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // cookId로 해당 Cook DAO 찾기
        CookDTO cookDTO = getCookDAOBean.exec(adminName, requestCookFinishUpdateDTO.getCookId());

        // DAO 수정
        cookDTO.setIsFinish(true);

        // 수정된 DAO 저장
        saveCookDAOBean.exec(adminName, cookDTO);

        // DTO 설정 및 반환
        return createCookFinishUpdateDTOBean.exec(cookDTO);
    }

}
