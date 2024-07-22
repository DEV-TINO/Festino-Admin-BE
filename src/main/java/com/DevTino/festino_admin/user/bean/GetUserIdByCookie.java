package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.user.jwt.JwtUtil;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserIdByCookie {
    public UUID exec(Cookie cookie, String secretKey) {
        String userId = JwtUtil.getUserId(cookie.getValue(), secretKey);

        return UUID.fromString(userId);
    }
}
