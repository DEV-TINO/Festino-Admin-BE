package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateCookFinishUpdateDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetCookDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveCookDAOBean;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCookFinishBean {

    GetCookDAOBean getCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    CreateCookFinishUpdateDTOBean createCookFinishUpdateDTOBean;

    @Autowired
    public UpdateCookFinishBean(GetCookDAOBean getCookDAOBean, SaveCookDAOBean saveCookDAOBean, CreateCookFinishUpdateDTOBean createCookFinishUpdateDTOBean){
        this.getCookDAOBean = getCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.createCookFinishUpdateDTOBean = createCookFinishUpdateDTOBean;
    }



    // Cook 조리 완료
    public ResponseCookFinishUpdateDTO exec(RequestCookFinishUpdateDTO requestCookFinishUpdateDTO){

        // cookId로 해당 Cook DAO 찾기
        CookDAO cookDAO = getCookDAOBean.exec(requestCookFinishUpdateDTO.getCookId());

        // DAO 수정
        cookDAO.setIsFinish(true);

        // 수정된 DAO 저장
        saveCookDAOBean.exec(cookDAO);

        // DTO 설정 및 반환
        return createCookFinishUpdateDTOBean.exec(cookDAO);

    }

}
