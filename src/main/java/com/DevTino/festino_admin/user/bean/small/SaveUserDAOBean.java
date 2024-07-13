package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserDAOBean {
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public SaveUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public void exec(UserDAO userDAO) {
        userRepositoryJPA.save(userDAO);
    }
}
