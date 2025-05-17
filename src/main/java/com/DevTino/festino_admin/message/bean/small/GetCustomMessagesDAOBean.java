package com.DevTino.festino_admin.message.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.repository.CustomMessageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCustomMessagesDAOBean {

    CustomMessageRepositoryJPA customMessageRepositoryJPA;

    @Autowired
    public GetCustomMessagesDAOBean(CustomMessageRepositoryJPA customMessageRepositoryJPA) {
        this.customMessageRepositoryJPA = customMessageRepositoryJPA;
    }

    public List<CustomMessageDAO> exec(UUID boothId) {

        List<CustomMessageDAO> daoList = customMessageRepositoryJPA.findByBoothIdOrderByMessageTypeAsc(boothId);
        if (daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;

    }
}
