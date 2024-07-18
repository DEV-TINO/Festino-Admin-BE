package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CheckRoleBean {
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public CheckRoleBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    public UserDAO exec() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userId);
        return getUserDAOBean.exec(UUID.fromString(userId));
    }
}
