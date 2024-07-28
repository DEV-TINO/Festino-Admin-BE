package com.DevTino.festino_admin.date.Service;

import com.DevTino.festino_admin.date.Bean.GetDateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    GetDateBean getDateBean;

    @Autowired
    public DateService(GetDateBean getDateBean){
        this.getDateBean = getDateBean;
    }

    // date(일차 수) 조회
    public Integer getDate(){

        return getDateBean.exec();

    }
}
