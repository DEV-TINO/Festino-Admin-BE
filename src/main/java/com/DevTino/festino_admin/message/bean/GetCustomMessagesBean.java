package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CreateCustomMessageDTOBean;
import com.DevTino.festino_admin.message.bean.small.GetCustomMessagesDAOBean;
import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.domain.DTO.ResponseCustomMessageGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCustomMessagesBean {

    GetCustomMessagesDAOBean getCustomMessagesDAOBean;
    CreateCustomMessageDTOBean createCustomMessageDTOBean;

    @Autowired
    public GetCustomMessagesBean(GetCustomMessagesDAOBean getCustomMessagesDAOBean, CreateCustomMessageDTOBean createCustomMessageDTOBean) {
        this.getCustomMessagesDAOBean = getCustomMessagesDAOBean;
        this.createCustomMessageDTOBean = createCustomMessageDTOBean;
    }

    // 커스텀 메세지 전체 조회
    public List<ResponseCustomMessageGetDTO> exec(UUID boothId) {

        List<CustomMessageDAO> customMessageDAOList = getCustomMessagesDAOBean.exec(boothId);

        return createCustomMessageDTOBean.exec(customMessageDAOList);
    }
}
