package com.DevTino.festino_admin.booth.bean;


import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothCallDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothCallUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothCallUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
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
        if(nightBoothDAO == null) return null;

        // DAO 예약가능 여부 수정
        if(requestNightBoothCallUpdateDTO.getIsCall() == nightBoothDAO.getIsCall())
            nightBoothDAO.setIsCall(!nightBoothDAO.getIsCall());
        else
            return null;

        // 수정된 DAO 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // DTO 생성해서 반환
        return createNightBoothCallDTOBean.exec(nightBoothDAO);
    }
}
