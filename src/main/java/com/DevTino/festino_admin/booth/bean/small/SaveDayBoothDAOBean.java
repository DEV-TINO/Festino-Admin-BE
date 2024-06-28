package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import com.DevTino.festino_admin.booth.repository.DayBoothRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveDayBoothDAOBean {
    DayBoothRepositoryJPA dayBoothRepository;

    @Autowired
    public SaveDayBoothDAOBean(DayBoothRepositoryJPA dayBoothRepository) {
        this.dayBoothRepository = dayBoothRepository;
    }

    //주간부스 DAO를 DB에 저장
    public void exec(DayBoothDAO dayBoothDAO) {
        dayBoothRepository.save(dayBoothDAO);
    }
}
