package com.DevTino.festino_admin.user.controller;

import com.DevTino.festino_admin.user.domain.DTO.*;
import com.DevTino.festino_admin.user.domain.UserDAO;
import com.DevTino.festino_admin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 저장
    @PostMapping("/join")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO){
        UUID userId = userService.saveUser(requestUserSaveDTO);

        // Map 이용해서 success, 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", userId != null);
        requestMap.put("message", userId == null ? "user save failure" : "user save success");
        requestMap.put("userId", userId == null ? "00000000-0000-0000-0000-000000000000" : userId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 유저 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO){
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
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody RequestUserDeleteDTO requestUserDeleteDTO){
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
}