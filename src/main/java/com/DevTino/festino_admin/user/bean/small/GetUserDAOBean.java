package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.DTO.RequestUserLoginDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.repository.UserRepositoryJPA;
import org.mindrot.jbcrypt.BCrypt;
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
      
        UserDAO userDAO = userRepositoryJPA.findByAdminId(adminId);

        // accountId로 조회했을 때 값이 없는 경우
        if(userDAO == null) return null;

        // 암호화된 비밀번호를 확인했을 때 일치한다면 true, 다르다면 false
        boolean flag = BCrypt.checkpw(passWord, userDAO.getPassWord());
        return flag ? userDAO : null;
    }
}
