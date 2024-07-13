package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersDAOBean {
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUsersDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // 전체 유저 조회
    public List<UserDAO> exec() {
        return userRepositoryJPA.findAll();
    }
}
