package com.DevTino.festino_admin.user.controller;

import com.DevTino.festino_admin.user.domain.DTO.*;
import com.DevTino.festino_admin.user.domain.RoleType;
import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 저장
    @PostMapping("/join")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO) {
        UUID userId = userService.saveUser(requestUserSaveDTO);

        // Map 이용해서 success, 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", userId != null);
        requestMap.put("message", userId == null ? "user save failure" : "user save success");
        requestMap.put("userId", userId == null ? "00000000-0000-0000-0000-000000000000" : userId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody RequestUserLoginDTO requestUserLoginDTO, HttpServletResponse response) {
        String accessToken = userService.login(requestUserLoginDTO);

        // Map 이용해서 success, 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", accessToken != null);
        requestMap.put("message", accessToken == null ? "user login failure" : "user login success");

        Cookie cookie = new Cookie("access_token", accessToken);
        cookie.setMaxAge(60*60*24);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        response.addCookie(cookie);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        String cookieName = "access_token";

        Cookie[] cookies = request.getCookies();

        boolean success = false;

        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookieName.equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    success = true;
                    break;
                }
            }
        }

        // Map 이용해서 success, 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "logout success" : "logout failure");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO) {
        UUID userId = userService.updateUser(requestUserUpdateDTO);

        // Map 이용해서 success, 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", userId != null);
        requestMap.put("message", userId == null ? "user update failure" : "user update success");
        requestMap.put("userId", userId == null ? "00000000-0000-0000-0000-000000000000" : userId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody RequestUserDeleteDTO requestUserDeleteDTO) {
        boolean success = userService.deleteUser(requestUserDeleteDTO);

        // Map 이용해서 success, 메시지 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "user delete success" : "user delete failure");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

    // 특정 유저 조회
    @GetMapping
    public ResponseEntity<Map<String, Object>> getUser(@RequestParam("userId") UUID userId) {
        UserDAO userDAO = userService.getUser(userId);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", userDAO != null);
        requestMap.put("message", userDAO == null ? "doesn't exist user" : "success get user");
        requestMap.put("user", userDAO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 전체 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getUserAll() {
        List<ResponseUsersGetDTO> userList = userService.getUserAll();

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", !userList.isEmpty());
        requestMap.put("message", userList.isEmpty() ? "doesn't exist user" : "success get users");
        requestMap.put("noticeList", userList.isEmpty() ? null : userList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // role 확인
    @PostMapping("/role")
    public ResponseEntity<Map<String, Object>> checkRole() {
        UserDAO userDAO = userService.checkRole();

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", userDAO != null);
        requestMap.put("message", userDAO == null ? "doesn't exist user" : "user exist");
        requestMap.put("role", userDAO == null ? null : userDAO.getRole() == RoleType.ADMIN);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}