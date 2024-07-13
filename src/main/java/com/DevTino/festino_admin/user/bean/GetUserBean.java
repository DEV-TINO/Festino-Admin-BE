package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserBean {
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public GetUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    // 특정 유저 조회
    public UserDAO exec(UUID userId) {
        return  getUserDAOBean.exec(userId);
    }
}
