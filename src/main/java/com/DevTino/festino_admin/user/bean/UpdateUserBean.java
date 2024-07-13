package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.SaveUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.UpdateUserDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserUpdateDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateUserBean {
    UpdateUserDAOBean updateUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public UpdateUserBean(UpdateUserDAOBean updateUserDAOBean, SaveUserDAOBean saveUserDAOBean, GetUserDAOBean getUserDAOBean) {
        this.updateUserDAOBean = updateUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
        this.getUserDAOBean = getUserDAOBean;
    }

    // 유저 수정
    public UUID exec(RequestUserUpdateDTO requestUserUpdateDTO) {
        UserDAO userDAO = getUserDAOBean.exec(requestUserUpdateDTO.getUserId());

        if(userDAO == null) return null;

        userDAO = updateUserDAOBean.exec(userDAO, requestUserUpdateDTO);
        saveUserDAOBean.exec(userDAO);

        return userDAO.getUserId();
    }
}
