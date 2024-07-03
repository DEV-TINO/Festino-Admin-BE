package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateNightBoothsDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseNightBoothsGetDTO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetNightBoothsBean {
    GetNightBoothDAOBean getNightBoothDAOBean;
    CreateNightBoothsDTOBean createNightBoothsDTOBean;

    @Autowired
    public GetNightBoothsBean(GetNightBoothDAOBean getNightBoothDAOBean, CreateNightBoothsDTOBean createNightBoothsDTOBean) {
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.createNightBoothsDTOBean = createNightBoothsDTOBean;
    }

    // 야간부스 전체조회
    public List<ResponseNightBoothsGetDTO> exec() {

        // 야간부스 전체 DAO 찾기
        List<NightBoothDAO> nightBoothDAOList = getNightBoothDAOBean.exec();
        if(nightBoothDAOList.isEmpty()) return null;

        // DAO 리스트를 DTO로 바꿔서 반환
        return createNightBoothsDTOBean.exec(nightBoothDAOList);
    }
}
