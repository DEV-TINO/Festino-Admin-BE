package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.UpdateCookCountBean;
import com.DevTino.festino_admin.order.bean.UpdateCookFinishBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestCookFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookCountUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseCookFinishUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookService {

    UpdateCookFinishBean updateCookFinishBean;
    UpdateCookCountBean updateCookCountBean;

    @Autowired
    public CookService(UpdateCookFinishBean updateCookFinishBean, UpdateCookCountBean updateCookCountBean){
        this.updateCookFinishBean = updateCookFinishBean;
        this.updateCookCountBean = updateCookCountBean;
    }



    // Cook 조리 완료
    public ResponseCookFinishUpdateDTO updateCookFinish(RequestCookFinishUpdateDTO requestCookFinishUpdateDTO){

        return updateCookFinishBean.exec(requestCookFinishUpdateDTO);

    }



    // 서빙 수량 변경
    public ResponseCookCountUpdateDTO updateCookCount(RequestCookCountUpdateDTO requestCookCountUpdateDTO){

        return updateCookCountBean.exec(requestCookCountUpdateDTO);

    }
}