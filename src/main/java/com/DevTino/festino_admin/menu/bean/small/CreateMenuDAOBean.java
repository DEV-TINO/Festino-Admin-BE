package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSaveDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateMenuDAOBean {

    // 메뉴 DAO 생성
    public MenuDAO exec(RequestMenuSaveDTO requestMenuSaveDTO) {
        return MenuDAO.builder()
                .menuId(UUID.randomUUID())
                .boothId(requestMenuSaveDTO.getBoothId())
                .menuName(requestMenuSaveDTO.getMenuName())
                .menuDescription(requestMenuSaveDTO.getMenuDescription())
                .menuImage(requestMenuSaveDTO.getMenuImage())
                .menuPrice(requestMenuSaveDTO.getMenuPrice())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isSoldOut(requestMenuSaveDTO.getIsSoldOut())
                .menuType(requestMenuSaveDTO.getMenuType())
                .build();
    }
}
