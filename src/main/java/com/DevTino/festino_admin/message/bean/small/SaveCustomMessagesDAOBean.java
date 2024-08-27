package com.DevTino.festino_admin.message.bean.small;

import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.repository.CustomMessageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveCustomMessagesDAOBean {

    CustomMessageRepositoryJPA customMessageRepositoryJPA;

    @Autowired
    public SaveCustomMessagesDAOBean(CustomMessageRepositoryJPA customMessageRepositoryJPA) {
        this.customMessageRepositoryJPA = customMessageRepositoryJPA;
    }

    public void exec(List<CustomMessageDAO> customMessageDAOS) {
        customMessageRepositoryJPA.saveAll(customMessageDAOS);
    }
}
