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

        // 메뉴 이미지 넣지 않았을때 빈값으로 넣어주는 예외처리
        String image = "";
        if (requestMenuSaveDTO.getMenuImage() != null)
            image = requestMenuSaveDTO.getMenuImage();

        return MenuDAO.builder()
                .menuId(UUID.randomUUID())
                .boothId(requestMenuSaveDTO.getBoothId())
                .menuName(requestMenuSaveDTO.getMenuName())
                .menuDescription(requestMenuSaveDTO.getMenuDescription())
                .menuImage(image)
                .menuPrice(requestMenuSaveDTO.getMenuPrice())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .isDeleted(false)
                .isSoldOut(requestMenuSaveDTO.getIsSoldOut())
                .menuType(requestMenuSaveDTO.getMenuType())
                .build();
    }
}
