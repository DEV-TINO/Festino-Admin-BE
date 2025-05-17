package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CreateCustomMessageDAOBean;
import com.DevTino.festino_admin.message.bean.small.DeleteCustomMessagesDAOBean;
import com.DevTino.festino_admin.message.bean.small.GetCustomMessagesDAOBean;
import com.DevTino.festino_admin.message.bean.small.SaveCustomMessagesDAOBean;
import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.domain.DTO.RequestCustomMessageSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SaveCustomMessageBean {

    GetCustomMessagesDAOBean getCustomMessagesDAOBean;
    DeleteCustomMessagesDAOBean deleteCustomMessagesDAOBean;
    CreateCustomMessageDAOBean createCustomMessageDAOBean;
    SaveCustomMessagesDAOBean saveCustomMessagesDAOBean;

    @Autowired
    public SaveCustomMessageBean(GetCustomMessagesDAOBean getCustomMessagesDAOBean, DeleteCustomMessagesDAOBean deleteCustomMessagesDAOBean, CreateCustomMessageDAOBean createCustomMessageDAOBean, SaveCustomMessagesDAOBean saveCustomMessagesDAOBean) {
        this.getCustomMessagesDAOBean = getCustomMessagesDAOBean;
        this.deleteCustomMessagesDAOBean = deleteCustomMessagesDAOBean;
        this.createCustomMessageDAOBean = createCustomMessageDAOBean;
        this.saveCustomMessagesDAOBean = saveCustomMessagesDAOBean;
    }

    public UUID exec(RequestCustomMessageSaveDTO requestCustomMessageSaveDTO) {

        // 기존 메세지 조회
        List<CustomMessageDAO> customMessageDAOList = getCustomMessagesDAOBean.exec(requestCustomMessageSaveDTO.getBoothId());

        // 기존 메세지 삭제
        deleteCustomMessagesDAOBean.exec(customMessageDAOList);

        List<CustomMessageDAO> newCustomMessageDAOList = createCustomMessageDAOBean.exec(requestCustomMessageSaveDTO);

        // 새로운 메세지 저장
        saveCustomMessagesDAOBean.exec(newCustomMessageDAOList);

        return requestCustomMessageSaveDTO.getBoothId();
    }
}
