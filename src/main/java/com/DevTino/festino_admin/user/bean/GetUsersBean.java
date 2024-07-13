package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.CreateResponseUsersGetDTOBean;
import com.DevTino.festino_admin.user.bean.small.GetUsersDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.ResponseUsersGetDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersBean {
    GetUsersDAOBean getUsersDAOBean;
    CreateResponseUsersGetDTOBean createResponseUsersGetDTOBean;

    @Autowired
    public GetUsersBean(GetUsersDAOBean getUsersDAOBean, CreateResponseUsersGetDTOBean createResponseUsersGetDTOBean) {
        this.getUsersDAOBean = getUsersDAOBean;
        this.createResponseUsersGetDTOBean = createResponseUsersGetDTOBean;
    }

    // 전체 유저 조회
    public List<ResponseUsersGetDTO> exec() {
        List<UserDAO> userDAOList = getUsersDAOBean.exec();

        List<ResponseUsersGetDTO> userList = createResponseUsersGetDTOBean.exec(userDAOList);
        return userList;
    }
}
