package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.SaveUserDAOBean;
import com.DevTino.festino_admin.user.bean.small.UpdateUserDAOBean;
import com.DevTino.festino_admin.user.domain.DTO.RequestUserUpdateDTO;
import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.jwt.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateUserBean {
    UpdateUserDAOBean updateUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;
    GetUserDAOBean getUserDAOBean;
    GetCookieBean getCookieBean;

    @Autowired
    public UpdateUserBean(UpdateUserDAOBean updateUserDAOBean, SaveUserDAOBean saveUserDAOBean, GetUserDAOBean getUserDAOBean, GetCookieBean getCookieBean) {
        this.updateUserDAOBean = updateUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.getCookieBean = getCookieBean;
    }

    // 유저 수정
    public UUID exec(RequestUserUpdateDTO requestUserUpdateDTO) {
        UserDAO userDAO = getUserDAOBean.exec(requestUserUpdateDTO.getUserId());

        if(userDAO == null) return null;

        updateUserDAOBean.exec(userDAO, requestUserUpdateDTO);
        saveUserDAOBean.exec(userDAO);

        return userDAO.getUserId();
    }
}
