package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.CreateUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.SaveUserDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {
    CreateUserDAOBean createUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public SaveUserBean(CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean, GetUserDAOBean getUserDAOBean) {
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
        this.getUserDAOBean = getUserDAOBean;
    }

    // 유저 저장
    public void exec(RequestUserSaveDTO requestUserSaveDTO) {
        UserDAO userDAO = createUserDAOBean.exec(requestUserSaveDTO);
        saveUserDAOBean.exec(userDAO);

        // 저장된 유저 확인
        getUserDAOBean.exec(userDAO.getUserId());
    }
}
