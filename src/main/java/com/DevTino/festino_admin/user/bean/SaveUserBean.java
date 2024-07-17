package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.CreateUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.SaveUserDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserBean {
    CreateUserDAOBean createUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public SaveUserBean(CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean) {
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }

    // 유저 저장
    public UUID exec(RequestUserSaveDTO requestUserSaveDTO) {
        UserDAO userDAO = createUserDAOBean.exec(requestUserSaveDTO);
        saveUserDAOBean.exec(userDAO);

        return userDAO.getUserId();
    }
}
