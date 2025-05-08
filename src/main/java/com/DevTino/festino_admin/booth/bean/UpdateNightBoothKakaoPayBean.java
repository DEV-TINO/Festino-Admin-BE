package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothKakaoPayBTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestNightBoothKakaoPayUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothKakaoPayUpdateDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateNightBoothKakaoPayBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    SaveNightBoothDAOBean saveNightBoothDAOBean;
    CreateNightBoothKakaoPayBTOBean createNightBoothKakaoPayBTOBean;

    @Autowired
    public UpdateNightBoothKakaoPayBean(GetNightBoothDAOBean getNightBoothDAOBean, SaveNightBoothDAOBean saveNightBoothDAOBean, CreateNightBoothKakaoPayBTOBean createNightBoothKakaoPayBTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.saveNightBoothDAOBean = saveNightBoothDAOBean;
        this.createNightBoothKakaoPayBTOBean = createNightBoothKakaoPayBTOBean;
    }

    // 카카오페이 가능 여부 수정
    public ResponseNightBoothKakaoPayUpdateDTO exec(RequestNightBoothKakaoPayUpdateDTO requestNightBoothKakaoPayUpdateDTO) {
        // boothId를 통해 원하는 객체 찾기
        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(requestNightBoothKakaoPayUpdateDTO.getBoothId());
        if (nightBoothDAO == null) return null;

        // 카카오페이 가능 여부 수정
        if (requestNightBoothKakaoPayUpdateDTO.getIsKakaoPay() == nightBoothDAO.getIsKakaoPay()) {
            nightBoothDAO.setIsKakaoPay(!nightBoothDAO.getIsKakaoPay());
        } else return null;

        // 수정한 객체 저장
        saveNightBoothDAOBean.exec(nightBoothDAO);

        // 객체값 DTO에 담아서 반환
        return createNightBoothKakaoPayBTOBean.exec(nightBoothDAO);
    }
}
