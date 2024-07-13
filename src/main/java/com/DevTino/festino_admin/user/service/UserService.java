package com.DevTino.festino_admin.user.service;

import com.DevTino.festino_admin.user.bean.DeleteUserBean;
import com.DevTino.festino_admin.user.bean.SaveUserBean;
import com.DevTino.festino_admin.user.bean.UpdateUserBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserDeleteDTO;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    DeleteUserBean deleteUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean, UpdateUserBean updateUserBean, DeleteUserBean deleteUserBean) {
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.deleteUserBean = deleteUserBean;
    }

    // 유저 저장
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        return saveUserBean.exec(requestUserSaveDTO);
    }

    // 유저 수정
    public UUID updateUser(RequestUserUpdateDTO requestUserUpdateDTO) {
        return updateUserBean.exec(requestUserUpdateDTO);
    }

    // 유저 삭제
    public Boolean deleteUser(RequestUserDeleteDTO requestUserDeleteDTO) {
        return deleteUserBean.exec(requestUserDeleteDTO);
    }
}
