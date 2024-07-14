package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenuGetDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateMenuDTOBean {
    // 메뉴 DTO 생성해서 반환
    public ResponseMenuGetDTO exec(MenuDAO menuDAO) {
        return ResponseMenuGetDTO.builder()
                .menuId(menuDAO.getMenuId())
                .menuName(menuDAO.getMenuName())
                .menuDescription(menuDAO.getMenuDescription())
                .menuPrice(menuDAO.getMenuPrice())
                .menuImage(menuDAO.getMenuImage())
                .isSoldOut(menuDAO.getIsSoldOut())
                .menuType(menuDAO.getMenuType().name())
                .build();
    }
}
