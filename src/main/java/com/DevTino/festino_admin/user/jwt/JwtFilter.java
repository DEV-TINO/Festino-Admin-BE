package com.DevTino.festino_admin.user.jwt;

import com.DevTino.festino_admin.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private UserService userService;
    private String secretKey;

    public JwtFilter(UserService userService, String secretKey) {
        this.userService = userService;
        this.secretKey = secretKey;
    }

    private String getTokenFromCookies(Cookie[] cookies) {
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if("access_token".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String accessToken = getTokenFromCookies(request.getCookies());

        log.info("Token from cookies : {}", accessToken);

        // token 보내지 않았거나 잘못 보냈을 경우 block
        if(accessToken == null || accessToken.isEmpty()) {
            log.error("doesn't exist token");
            filterChain.doFilter(request, response);
            return;
        }

        // Token 만료시간 확인
        if(JwtUtil.isExpired(accessToken, secretKey)) {
            log.error("token is expired");
            filterChain.doFilter(request, response);
            return;
        }

        String userId = JwtUtil.getUserId(accessToken, secretKey);
        log.info("userId : {}", userId);

        String role = JwtUtil.getUserRole(accessToken, secretKey);
        log.info("role : {}", role);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("MEMBER"));
        if(role != null && role.equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, null, authorities);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
