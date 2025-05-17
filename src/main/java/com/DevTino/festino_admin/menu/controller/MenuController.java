package com.DevTino.festino_admin.menu.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.menu.domain.DTO.*;
import com.DevTino.festino_admin.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<ApiResponse<Object>> saveMenu(@RequestBody RequestMenuSaveDTO requestMenuSaveDTO) {
        // 메뉴 저장 service
        UUID menuId = menuService.saveMenu(requestMenuSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "메뉴 저장 성공", menuId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 메뉴 수정
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateMenu(@RequestBody RequestMenuUpdateDTO requestMenuUpdateDTO) {
        // 메뉴 수정 service
        UUID menuId = menuService.updateMenu(requestMenuUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "메뉴 수정 성공", menuId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 메뉴 수정
    @PutMapping("/sold-out")
    public ResponseEntity<ApiResponse<Object>> updateMenuSoldOut(@RequestBody RequestMenuSoldOutUpdateDTO requestMenuSoldOutUpdateDTO) {
        // 메뉴 수정 service
        ResponseMenuSoldOutUpdateDTO responseMenuSoldOutUpdateDTO = menuService.updateMenuSoldOut(requestMenuSoldOutUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "메뉴 수정 성공", responseMenuSoldOutUpdateDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 메뉴 삭제
    @DeleteMapping
    public ResponseEntity<ApiResponse<Object>> deleteMenu(@RequestBody RequestMenuDeleteDTO requestMenuDeleteDTO) {
        // 메뉴 삭제 service
        UUID menuId = menuService.deleteMenu(requestMenuDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "메뉴 삭제 성공", menuId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 메뉴 조회
    @GetMapping("/{menuId}")
    public ResponseEntity<ApiResponse<Object>> getMenu(@PathVariable("menuId") UUID menuId) {
        // 메뉴 조회 service
        ResponseMenuGetDTO responseMenuGetDTO = menuService.getMenu(menuId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "메뉴 조회 성공", responseMenuGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 메뉴 전체조회
    @GetMapping("/all/booth/{boothId}")
    public ResponseEntity<ApiResponse<Object>> getMenuAll(@PathVariable("boothId") UUID boothId) {
        // 메뉴 전체조회 service
        List<ResponseMenuGetDTO> responseMenuGetDTOList = menuService.getMenuAll(boothId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "메뉴 전체조회 성공", responseMenuGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
