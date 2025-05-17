package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothTossPayBTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothTossPayUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothTossPayUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateNightBoothTossPayBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothTossPayBTOBean createNightBoothTossPayBTOBean;

    @Autowired
    public UpdateNightBoothTossPayBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothTossPayBTOBean createNightBoothTossPayBTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothTossPayBTOBean = createNightBoothTossPayBTOBean;
    }

    // 토스페이 가능 여부 수정
    public ResponseNightBoothTossPayUpdateDTO exec(RequestNightBoothTossPayUpdateDTO requestNightBoothTossPayUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothTossPayUpdateDTO.getBoothId());

        // 토스페이 가능 여부가 입력값과 다른 경우 예외 발생
        if (requestNightBoothTossPayUpdateDTO.getIsTossPay() != nightBoothDAO.getIsTossPay()) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // 토스페이 가능 여부 수정
        nightBoothDAO.setIsTossPay(!nightBoothDAO.getIsTossPay());
        
        // 수정사항 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothTossPayBTOBean.exec(nightBoothDAO);
    }
}
