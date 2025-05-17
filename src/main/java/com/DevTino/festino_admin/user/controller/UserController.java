package com.DevTino.festino_admin.user.controller;

import com.DevTino.festino_admin.ApiResponse;
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

import java.util.List;
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
    public ResponseEntity<ApiResponse<Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO) {
        userService.saveUser(requestUserSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "user save success", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 유저 로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Object>> loginUser(@RequestBody RequestUserLoginDTO requestUserLoginDTO, HttpServletResponse response) {
        Cookie[] cookies = userService.login(requestUserLoginDTO);

        if(cookies != null) {
            for(Cookie c : cookies) {
                response.addCookie(c);
            }
        }

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "user login success", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 유저 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Object>> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = userService.getCookie(request);

        if(cookie != null) {
            Cookie c = new Cookie("access_token", "");
            c.setMaxAge(0);
            c.setPath("/");
            response.addCookie(c);
        }

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "logout success", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 유저 수정
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateUser(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO) {
        UUID userId = userService.updateUser(requestUserUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "user update success", userId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 유저 삭제
    @DeleteMapping
    public ResponseEntity<ApiResponse<Object>> deleteUser(@RequestBody RequestUserDeleteDTO requestUserDeleteDTO) {
        userService.deleteUser(requestUserDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "user delete success", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 특정 유저 조회
    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getUser(@RequestParam("userId") UUID userId) {
        UserDAO userDAO = userService.getUser(userId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "success get user", userDAO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 유저 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getUserAll() {
        List<ResponseUsersGetDTO> userList = userService.getUserAll();

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "success get users", userList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // role 확인
    @PostMapping("/role")
    public ResponseEntity<ApiResponse<Object>> checkRole() {
        UserDAO userDAO = userService.checkRole();

        // Map 이용해서 반환값 json 데이터로 변환
        Boolean isAdmin = (userDAO.getRole() == RoleType.ADMIN);
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "success check role", isAdmin);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // 부스 아이디 확인
    @GetMapping("/booth")
    public ResponseEntity<ApiResponse<Object>> getBoothByAdminName(HttpServletRequest request) {
        UUID boothId = userService.getBooth(request);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> apiResponse = new ApiResponse<>(true, "search success", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}