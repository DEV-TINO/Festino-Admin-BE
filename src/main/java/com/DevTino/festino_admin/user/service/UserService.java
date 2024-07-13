package com.DevTino.festino_admin.user.service;

import com.DevTino.festino_admin.user.bean.SaveUserBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean) {
        this.saveUserBean = saveUserBean;
    }

    // 유저 저장
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        return saveUserBean.exec(requestUserSaveDTO);
    }
}
