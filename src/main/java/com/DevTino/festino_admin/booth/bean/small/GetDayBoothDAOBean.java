package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import com.DevTino.festino_admin.booth.repository.DayBoothRepositoryJPA;
import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetDayBoothDAOBean {
    DayBoothRepositoryJPA dayBoothRepository;

    @Autowired
    public GetDayBoothDAOBean(DayBoothRepositoryJPA dayBoothRepository) {
        this.dayBoothRepository = dayBoothRepository;
    }

    // 부스아이디로 DAO 찾아서 반환
    public DayBoothDAO exec(UUID boothId) {

        DayBoothDAO dao = dayBoothRepository.findById(boothId).orElse(null);
        if (dao ==  null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // 전체 주간부스 DAO 찾아서 반환
    public List<DayBoothDAO> exec() {

        List<DayBoothDAO> daoList = dayBoothRepository.findAll();
        if (daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;

    }

    // adminName으로 DAO 찾아서 반환
    public DayBoothDAO exec(String adminName) { return dayBoothRepository.findByAdminName(adminName); }
}
