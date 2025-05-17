package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothOpenDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateNightBoothOpenBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothOpenDTOBean createNightBoothOpenDTOBean;

    @Autowired
    public UpdateNightBoothOpenBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothOpenDTOBean createNightBoothOpenDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothOpenDTOBean = createNightBoothOpenDTOBean;
    }

    // 야간부스 운영 중 여부 수정
    public ResponseNightBoothOpenUpdateDTO exec(RequestNightBoothOpenUpdateDTO requestNightBoothOpenUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothOpenUpdateDTO.getBoothId());

        // 부스 운영중 여부와 입력값이 다른 경우 예외 발생
        if(requestNightBoothOpenUpdateDTO.getIsOpen() != nightBoothDAO.getIsOpen()) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // DAO 운영 중 여부 수정
        nightBoothDAO.setIsOpen(!nightBoothDAO.getIsOpen());

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothOpenDTOBean.exec(nightBoothDAO);
    }
}
