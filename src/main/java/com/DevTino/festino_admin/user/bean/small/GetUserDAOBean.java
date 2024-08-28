package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.DTO.RequestUserLoginDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.repository.UserRepositoryJPA;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class GetUserDAOBean {
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // id로 특정 유저 조회
    public UserDAO exec(UUID userId) {
        return userRepositoryJPA.findById(userId).orElse(null);
    }

    // adminId와 passWord로 특정 유저 조회
    public UserDAO exec(RequestUserLoginDTO requestUserLoginDTO) {
        String adminId = new String(Base64.decodeBase64(requestUserLoginDTO.getAdminId()), StandardCharsets.UTF_8);
        String passWord = new String(Base64.decodeBase64(requestUserLoginDTO.getPassWord()), StandardCharsets.UTF_8);
        return userRepositoryJPA.findByAdminIdAndPassWord(adminId, passWord);
    }
}
