package com.DevTino.festino_admin.user.controller;

import com.DevTino.festino_admin.user.domain.DTO.RequestUserSaveDTO;
import com.DevTino.festino_admin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO){
        UUID userId = userService.saveUser(requestUserSaveDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", userId != null);
        requestMap.put("message", userId == null ? "user save failure" : "user save success");
        requestMap.put("userId", userId == null ? "00000000-0000-0000-0000-000000000000" : userId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}