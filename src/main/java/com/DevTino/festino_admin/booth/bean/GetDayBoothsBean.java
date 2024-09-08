package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateDayBoothsDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetDayBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothsGetDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetDayBoothsBean {
    GetDayBoothDAOBean getDayBoothDAOBean;
    CreateDayBoothsDTOBean createDayBoothsDTOBean;

    @Autowired
    public GetDayBoothsBean(GetDayBoothDAOBean getDayBoothDAOBean, CreateDayBoothsDTOBean createDayBoothsDTOBean) {
        this.getDayBoothDAOBean = getDayBoothDAOBean;
        this.createDayBoothsDTOBean = createDayBoothsDTOBean;
    }

    // 주간부스 전체조회
    public List<ResponseDayBoothsGetDTO> exec() {

        // 주간부스 전체 DAO 가져오기
        List<DayBoothDAO> dayBoothDAOList = getDayBoothDAOBean.exec();
        if(dayBoothDAOList.isEmpty()) return new ArrayList<>();

        // DAO 리스트를 DTO로 바꿔서 반환
        return createDayBoothsDTOBean.exec(dayBoothDAOList);
    }
}
