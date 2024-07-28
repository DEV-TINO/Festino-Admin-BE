package com.DevTino.festino_admin.user.bean.small;

import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

@Component
public class CreateCookieBean {
    public Cookie exec(String tokenName, String token) {
        Cookie cookie = new Cookie(tokenName, token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*60*24);

        return cookie;
    }
}
