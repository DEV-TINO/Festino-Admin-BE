package com.DevTino.festino_admin.user.bean.small;

import com.DevTino.festino_admin.user.domain.DTO.ResponseUsersGetDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateResponseUsersGetDTOBean {

    // List<UserDAO> -> List<ResponseUsersGetDTO>
    public List<ResponseUsersGetDTO> exec(List<UserDAO> userDAOList) {
        List<ResponseUsersGetDTO> userList = new ArrayList<>();

        for(UserDAO user : userDAOList) {
            ResponseUsersGetDTO responseUsersGetDTO = ResponseUsersGetDTO.builder()
                    .adminId(user.getAdminId())
                    .adminName(user.getAdminName())
                    .passWord(user.getPassWord())
                    .role(user.getRole())
                    .category(user.getAdminCategory())
                    .build();

            userList.add(responseUsersGetDTO);
        }

        return userList;
    }
}
