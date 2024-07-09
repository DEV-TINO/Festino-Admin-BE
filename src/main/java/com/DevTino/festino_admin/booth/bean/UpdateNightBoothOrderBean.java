package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothOrderDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothOrderUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOrderUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateNightBoothOrderBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothOrderDTOBean createNightBoothOrderDTOBean;

    @Autowired
    public UpdateNightBoothOrderBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothOrderDTOBean createNightBoothOrderDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothOrderDTOBean = createNightBoothOrderDTOBean;
    }

    // 야간부스 주문가능 여부 수정
    public ResponseNightBoothOrderUpdateDTO exec(RequestNightBoothOrderUpdateDTO requestNightBoothOrderUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothOrderUpdateDTO.getBoothId());
        if(nightBoothDAO == null) return null;

        // DAO 주문가능 여부 수정
        if(requestNightBoothOrderUpdateDTO.getIsOrder() == nightBoothDAO.getIsOrder())
            nightBoothDAO.setIsOrder(!nightBoothDAO.getIsOrder());
        else
            return null;

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothOrderDTOBean.exec(nightBoothDAO);
    }
}
