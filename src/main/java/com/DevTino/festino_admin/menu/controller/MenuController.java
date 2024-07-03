package com.DevTino.festino_admin.menu.controller;

import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSaveDTO;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuUpdateDTO;
import com.DevTino.festino_admin.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/menu")
public class MenuController {
    MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 메뉴 저장
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveMenu(@RequestBody RequestMenuSaveDTO requestMenuSaveDTO) {
        // 메뉴 저장 service
        UUID menuId = menuService.saveMenu(requestMenuSaveDTO);

        // 메뉴 저장 성공 여부
        boolean success = menuId != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "메뉴 저장 성공" : "메뉴 저장 시 DAO 등록 실패");
        requestMap.put("menuId", menuId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 메뉴 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateMenu(@RequestBody RequestMenuUpdateDTO requestMenuUpdateDTO) {
        // 메뉴 수정 service
        UUID menuId = menuService.updateMenu(requestMenuUpdateDTO);

        // 메뉴 수정 성공 여부
        boolean success = menuId != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "메뉴 수정 성공" : "메뉴 수정 시 DAO 등록 실패");
        requestMap.put("menuId", menuId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
