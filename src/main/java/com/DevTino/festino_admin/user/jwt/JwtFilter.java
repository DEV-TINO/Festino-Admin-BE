package com.DevTino.festino_admin.user.jwt;

import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.UserDAO;
import io.jsonwebtoken.ExpiredJwtException;
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
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private String secretKey;
    private GetUserDAOBean getUserDAOBean;

    public JwtFilter(GetUserDAOBean getUserDAOBean, String secretKey) {
        this.getUserDAOBean = getUserDAOBean;
        this.secretKey = secretKey;
    }

    private String getTokenFromCookies(Cookie[] cookies, String tokenName) {
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(tokenName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public void addToken(HttpServletResponse response, String tokenName, String token, int maxAge) {
        Cookie cookie = new Cookie(tokenName, token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String accessToken = getTokenFromCookies(request.getCookies(), "access_token");
        final String refreshToken = getTokenFromCookies(request.getCookies(), "refresh_token");

        log.info("AccessToken from cookies : {}", accessToken);
        log.info("RefreshToken from cookies : {}", refreshToken);

        try {
            if (accessToken != null && !accessToken.isEmpty() && !JwtUtil.isExpired(accessToken, secretKey)) {
                authenticateUser(accessToken, request);
            }
        } catch (ExpiredJwtException e) {
            if (refreshToken != null && !refreshToken.isEmpty() && !JwtUtil.isExpired(refreshToken, secretKey)) {
                // AccessToken이 없지만 RefreshToken이 유효한 경우
                String userId = JwtUtil.getUserId(refreshToken, secretKey);
                UserDAO userDAO = getUserDAOBean.exec(UUID.fromString(userId));
                String role = userDAO == null ? null : userDAO.getRole().name();

                String newAccessToken = JwtUtil.createAccessToken(UUID.fromString(userId), role, secretKey);
                addToken(response, "access_token", newAccessToken, 60 * 60 * 24);

                String newRefreshToken = JwtUtil.createRefreshToken(UUID.fromString(userId), secretKey);
                addToken(response, "refresh_token", newRefreshToken, 60 * 60 * 24);

                authenticateUser(newAccessToken, request);
            }
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token, HttpServletRequest request) {
        String userId = JwtUtil.getUserId(token, secretKey);
        String role = JwtUtil.getUserRole(token, secretKey);
        log.info("userId : {}", userId);
        log.info("role : {}", role);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("MEMBER"));
        if (role != null && role.equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, null, authorities);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
