package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
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

        UserDAO dao = userRepositoryJPA.findById(userId).orElse(null);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // adminId와 passWord로 특정 유저 조회
    public UserDAO exec(RequestUserLoginDTO requestUserLoginDTO) {
        String adminId = new String(Base64.decodeBase64(requestUserLoginDTO.getAdminId()), StandardCharsets.UTF_8);
        String passWord = new String(Base64.decodeBase64(requestUserLoginDTO.getPassWord()), StandardCharsets.UTF_8);
      
        UserDAO userDAO = userRepositoryJPA.findByAdminId(adminId);

        // accountId로 조회했을 때 값이 없는 경우 예외 발생
        if(userDAO == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        // 암호화된 비밀번호를 확인하고 다른 경우 예외 발생
        boolean flag = BCrypt.checkpw(passWord, userDAO.getPassWord());
        if (!flag) throw new ServiceException(ExceptionEnum.PASSWORD_MISMATCH);
        
        return userDAO;
    }
}
