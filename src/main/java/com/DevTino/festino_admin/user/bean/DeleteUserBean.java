package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.DeleteUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserDeleteDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserBean {
    GetUserDAOBean getUserDAOBean;
    DeleteUserDAOBean deleteUserDAOBean;

    @Autowired
    public DeleteUserBean(GetUserDAOBean getUserDAOBean, DeleteUserDAOBean deleteUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.deleteUserDAOBean = deleteUserDAOBean;
    }

    // 유저 삭제
    public Boolean exec(RequestUserDeleteDTO requestUserDeleteDTO) {
        UserDAO userDAO = getUserDAOBean.exec(requestUserDeleteDTO.getUserId());

        if(userDAO == null) return false;

        deleteUserDAOBean.exec(userDAO);

        return true;
    }
}
