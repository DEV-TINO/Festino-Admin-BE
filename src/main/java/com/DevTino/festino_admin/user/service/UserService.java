package com.DevTino.festino_admin.user.service;

import com.DevTino.festino_admin.user.bean.*;
import com.DevTino.festino_admin.user.domain.DTO.*;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    DeleteUserBean deleteUserBean;
    GetUserBean getUserBean;
    GetUsersBean getUsersBean;
    CheckUserBean checkUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean, UpdateUserBean updateUserBean, DeleteUserBean deleteUserBean, GetUserBean getUserBean, GetUsersBean getUsersBean, CheckUserBean checkUserBean) {
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.deleteUserBean = deleteUserBean;
        this.getUserBean = getUserBean;
        this.getUsersBean = getUsersBean;
        this.checkUserBean = checkUserBean;
    }

    // 유저 저장
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        return saveUserBean.exec(requestUserSaveDTO);
    }

    // 유저 로그인
    public Boolean login(RequestUserLoginDTO requestUserLoginDTO) {
        return checkUserBean.exec(requestUserLoginDTO);
    }

    // 유저 수정
    public UUID updateUser(RequestUserUpdateDTO requestUserUpdateDTO) {
        return updateUserBean.exec(requestUserUpdateDTO);
    }

    // 유저 삭제
    public Boolean deleteUser(RequestUserDeleteDTO requestUserDeleteDTO) {
        return deleteUserBean.exec(requestUserDeleteDTO);
    }

    // 특정 유저 조회
    public UserDAO getUser(UUID userId) {
        return getUserBean.exec(userId);
    }

    // 유저 전체 조회
    public List<ResponseUsersGetDTO> getUserAll() {
        return getUsersBean.exec();
    }
}
