package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateCookCountUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetCookDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderBoothNameDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveCookDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateCookCountBean {

    static Integer minCount = 0;
    GetCookDAOBean getCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    CreateCookCountUpdateDTOBean createCookCountUpdateDTOBean;
    GetOrderBoothNameDAOBean getOrderBoothNameDAOBean;

    @Autowired
    public UpdateCookCountBean(GetCookDAOBean getCookDAOBean, SaveCookDAOBean saveCookDAOBean, CreateCookCountUpdateDTOBean createCookCountUpdateDTOBean, GetOrderBoothNameDAOBean getOrderBoothNameDAOBean) {
        this.getCookDAOBean = getCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.createCookCountUpdateDTOBean = createCookCountUpdateDTOBean;
        this.getOrderBoothNameDAOBean = getOrderBoothNameDAOBean;
    }

    // 서빙 수량 변경
    public ResponseCookCountUpdateDTO exec(UUID boothId, RequestCookCountUpdateDTO requestCookCountUpdateDTO){
        // 주문한 학과 구분
        String adminName = getOrderBoothNameDAOBean.exec(boothId);
        if(adminName.isEmpty()) return null;

        // cookId로 해당 Cook DAO 찾기
        CookDTO cookDTO = getCookDAOBean.exec(adminName, requestCookCountUpdateDTO.getCookId());
        if (cookDTO == null) return null;

        // 서빙 수량이 적정 범위가 아니라면 null 리턴
        Integer servedCount = requestCookCountUpdateDTO.getServedCount();
        if (!(servedCount >= minCount && servedCount <= cookDTO.getTotalCount())) return null;

        // DAO 수정
        cookDTO.setServedCount(servedCount);

        // 수정된 DAO 저장
        saveCookDAOBean.exec(adminName, cookDTO);

        // DTO 설정 및 반환
        return createCookCountUpdateDTOBean.exec(cookDTO);

    }

}
