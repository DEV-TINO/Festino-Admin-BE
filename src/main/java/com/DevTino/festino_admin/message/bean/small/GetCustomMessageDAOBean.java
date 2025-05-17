package com.DevTino.festino_admin.message.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.domain.ENUM.MessageType;
import com.DevTino.festino_admin.message.repository.CustomMessageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCustomMessageDAOBean {

    CustomMessageRepositoryJPA customMessageRepositoryJPA;

    @Autowired
    public GetCustomMessageDAOBean(CustomMessageRepositoryJPA customMessageRepositoryJPA) {
        this.customMessageRepositoryJPA = customMessageRepositoryJPA;
    }

    public CustomMessageDAO exec(UUID boothId, MessageType messageType) {

        CustomMessageDAO dao = customMessageRepositoryJPA.findByBoothIdAndMessageType(boothId, messageType);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }
}
