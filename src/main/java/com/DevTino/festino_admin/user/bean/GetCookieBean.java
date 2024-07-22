package com.DevTino.festino_admin.user.bean;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class GetCookieBean {

    // 토큰이 들어있는 쿠키 조회
    public Cookie exec(HttpServletRequest request) {
        String cookieName = "access_token";

        Cookie[] cookies = request.getCookies();

        Cookie cookie = null;

        if(cookies != null) {
            for(Cookie c : cookies) {
                if(cookieName.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }
        }

        return cookie;
    }
}
