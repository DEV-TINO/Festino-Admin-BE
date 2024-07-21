package com.DevTino.festino_admin.menu.controller;

import com.DevTino.festino_admin.menu.domain.DTO.*;
import com.DevTino.festino_admin.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
// @CrossOrigin("*")
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

    // 메뉴 수정
    @PutMapping("/sold-out")
    public ResponseEntity<Map<String, Object>> updateMenuSoldOut(@RequestBody RequestMenuSoldOutUpdateDTO requestMenuSoldOutUpdateDTO) {
        // 메뉴 수정 service
        ResponseMenuSoldOutUpdateDTO responseMenuSoldOutUpdateDTO = menuService.updateMenuSoldOut(requestMenuSoldOutUpdateDTO);

        // 메뉴 수정 성공 여부
        boolean success = responseMenuSoldOutUpdateDTO != null;

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "메뉴 품절여부 수정 성공" : "메뉴 품절여부 수정 시 DAO 등록 실패");
        requestMap.put("soldOutInfo", responseMenuSoldOutUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 메뉴 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteMenu(@RequestBody RequestMenuDeleteDTO requestMenuDeleteDTO) {
        // 메뉴 삭제 service 성공 여부
        boolean success = menuService.deleteMenu(requestMenuDeleteDTO);

        // Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "메뉴 삭제 성공" : "메뉴 삭제 시 DAO 검색 실패");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 메뉴 조회
    @GetMapping("/{menuId}")
    public ResponseEntity<Map<String, Object>> getMenu(@PathVariable("menuId") UUID menuId) {
        // 메뉴 조회 service
        ResponseMenuGetDTO responseMenuGetDTO = menuService.getMenu(menuId);

        // 메뉴 조회 성공 여부
        boolean success = responseMenuGetDTO != null;

        // Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "메뉴 조회 성공" : "메뉴 조회 시 DAO 검색 실패");
        requestMap.put("menuInfo", responseMenuGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 메뉴 전체조회
    @GetMapping("/all/booth/{boothId}")
    public ResponseEntity<Map<String, Object>> getMenuAll(@PathVariable("boothId") UUID boothId) {
        // 메뉴 전체조회 service
        List<ResponseMenuGetDTO> responseMenuGetDTOList = menuService.getMenuAll(boothId);

        // 메뉴 전체조회 성공 여부
        boolean success = responseMenuGetDTOList != null;

        // Map을 통해 메시지와 List 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "메뉴 전체조회 성공" : "메뉴 전체조회 DAO 검색 실패");
        requestMap.put("menuList", responseMenuGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
