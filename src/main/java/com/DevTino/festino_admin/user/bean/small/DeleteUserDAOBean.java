package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserDAOBean {
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public DeleteUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // 유저 삭제
    public void exec(UserDAO userDAO) {
        userRepositoryJPA.delete(userDAO);
    }
}
