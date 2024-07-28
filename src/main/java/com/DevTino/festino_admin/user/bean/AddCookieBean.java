package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.bean.small.CreateCookieBean;
import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.jwt.JwtUtil;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddCookieBean {
    CreateCookieBean createCookieBean;

    @Autowired
    public AddCookieBean(CreateCookieBean createCookieBean) {
        this.createCookieBean = createCookieBean;
    }

    public Cookie[] exec(UserDAO userDAO, String secretKey) {
        Cookie[] cookies = new Cookie[2];

        cookies[0] = createCookieBean.exec("access_token", JwtUtil.createAccessToken(userDAO.getUserId(), userDAO.getRole().name(), secretKey));
        cookies[1] = createCookieBean.exec("refresh_token", JwtUtil.createRefreshToken(userDAO.getUserId(), secretKey));

        return cookies;
    }
}
