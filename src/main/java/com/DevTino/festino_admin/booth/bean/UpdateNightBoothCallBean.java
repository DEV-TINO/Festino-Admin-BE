package com.DevTino.festino_admin.booth.bean;


import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothCallDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothCallUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothCallUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class UpdateNightBoothCallBean {

    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothCallDTOBean createNightBoothCallDTOBean;

    public UpdateNightBoothCallBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothCallDTOBean createNightBoothCallDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothCallDTOBean = createNightBoothCallDTOBean;
    }

    public ResponseNightBoothCallUpdateDTO exec(RequestNightBoothCallUpdateDTO requestNightBoothCallUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothCallUpdateDTO.getBoothId());

        // 직원 호출 가능 여부가 입력값과 다른 경우 예외 발생
        if (requestNightBoothCallUpdateDTO.getIsCall() != nightBoothDAO.getIsCall()) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // 직원 호출 가능 여부 수정
        nightBoothDAO.setIsCall(!nightBoothDAO.getIsCall());

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothCallDTOBean.exec(nightBoothDAO);
    }
}
