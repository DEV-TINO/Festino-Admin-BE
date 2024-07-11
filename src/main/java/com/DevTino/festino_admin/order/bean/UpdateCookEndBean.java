package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateCookEndUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetCookDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveCookDAOBean;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookEndUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookEndUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCookEndBean {

    GetCookDAOBean getCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    CreateCookEndUpdateDTOBean createCookEndUpdateDTOBean;

    @Autowired
    public UpdateCookEndBean(GetCookDAOBean getCookDAOBean, SaveCookDAOBean saveCookDAOBean, CreateCookEndUpdateDTOBean createCookEndUpdateDTOBean){
        this.getCookDAOBean = getCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.createCookEndUpdateDTOBean = createCookEndUpdateDTOBean;
    }



    // Cook 조리 완료
    public ResponseCookEndUpdateDTO exec(RequestCookEndUpdateDTO requestCookEndUpdateDTO){

        // cookId로 해당 Cook DAO 찾기
        CookDAO cookDAO = getCookDAOBean.exec(requestCookEndUpdateDTO.getCookId());

        // DAO 수정
        cookDAO.setIsEnd(true);

        // 수정된 DAO 저장
        saveCookDAOBean.exec(cookDAO);

        // DTO 설정 및 반환
        return createCookEndUpdateDTOBean.exec(cookDAO);

    }

}
