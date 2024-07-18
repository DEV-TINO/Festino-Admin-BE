package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateCookCountUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetCookDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveCookDAOBean;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCookCountBean {

    static Integer minCount = 0;
    GetCookDAOBean getCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    CreateCookCountUpdateDTOBean createCookCountUpdateDTOBean;

    @Autowired
    public UpdateCookCountBean(GetCookDAOBean getCookDAOBean, SaveCookDAOBean saveCookDAOBean, CreateCookCountUpdateDTOBean createCookCountUpdateDTOBean){
        this.getCookDAOBean = getCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.createCookCountUpdateDTOBean = createCookCountUpdateDTOBean;
    }



    // 서빙 수량 변경
    public ResponseCookCountUpdateDTO exec(RequestCookCountUpdateDTO requestCookCountUpdateDTO){

        // cookId로 해당 Cook DAO 찾기
        CookDAO cookDAO = getCookDAOBean.exec(requestCookCountUpdateDTO.getCookId());
        if (cookDAO == null) return null;

        // 서빙 수량이 적정 범위가 아니라면 null 리턴
        Integer servedCount = requestCookCountUpdateDTO.getServedCount();
        if (!(servedCount >= minCount && servedCount <= cookDAO.getTotalCount())) return null;

        // DAO 수정
        cookDAO.setServedCount(servedCount);

        // 수정된 DAO 저장
        saveCookDAOBean.exec(cookDAO);

        // DTO 설정 및 반환
        return createCookCountUpdateDTOBean.exec(cookDAO);

    }

}
