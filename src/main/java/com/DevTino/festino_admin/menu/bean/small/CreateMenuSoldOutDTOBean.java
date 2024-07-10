package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenuSoldOutUpdateDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateMenuSoldOutDTOBean {

    // 메뉴 품절 여부 DTO 생성
    public ResponseMenuSoldOutUpdateDTO exec(MenuDAO menuDAO) {
        return ResponseMenuSoldOutUpdateDTO.builder()
                .menuId(menuDAO.getMenuId())
                .isSoldOut(menuDAO.getIsSoldOut())
                .build();
    }
}
