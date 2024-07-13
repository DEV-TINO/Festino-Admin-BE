package com.DevTino.festino_admin.user.service;

import com.DevTino.festino_admin.user.bean.SaveUserBean;
import com.DevTino.festino_admin.user.bean.UpdateUserBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean, UpdateUserBean updateUserBean) {
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
    }

    // 유저 저장
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        return saveUserBean.exec(requestUserSaveDTO);
    }

    public UUID updateUser(RequestUserUpdateDTO requestUserUpdateDTO) {
        return updateUserBean.exec(requestUserUpdateDTO);
    }
}
