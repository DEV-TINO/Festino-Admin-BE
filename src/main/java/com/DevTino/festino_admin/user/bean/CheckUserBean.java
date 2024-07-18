package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserLoginDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckUserBean {
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public CheckUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    public UserDAO exec(RequestUserLoginDTO requestUserLoginDTO) {
        return getUserDAOBean.exec(requestUserLoginDTO);
    }

}
