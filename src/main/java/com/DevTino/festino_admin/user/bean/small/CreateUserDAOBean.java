package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {

    // RequestUserSaveDTO -> UserDAO
    public UserDAO exec(RequestUserSaveDTO requestUserSaveDTO) {
        return UserDAO.builder()
                .userId(UUID.randomUUID())
                .adminId(requestUserSaveDTO.getAdminId())
                .adminName(requestUserSaveDTO.getAdminName())
                .passWord(BCrypt.hashpw(requestUserSaveDTO.getPassWord(), BCrypt.gensalt()))
                .role(requestUserSaveDTO.getRole())
                .adminCategory(requestUserSaveDTO.getCategory())
                .build();
    }
}
