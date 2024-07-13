package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {
    public UserDAO exec(RequestUserSaveDTO requestUserSaveDTO) {
        return UserDAO.builder()
                .userId(UUID.randomUUID())
                .adminId(requestUserSaveDTO.getAdminId())
                .adminName(requestUserSaveDTO.getAdminName())
                .passWord(requestUserSaveDTO.getPassWord())
                .role(requestUserSaveDTO.getRole())
                .adminCategory(requestUserSaveDTO.getCategory())
                .build();
    }
}
