package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.menu.repository.MenuRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetMenuDAOBean {
    MenuRepositoryJPA menuRepositoryJPA;

    @Autowired
    public GetMenuDAOBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    // menuId를 통해 원하는 DAO 찾아서 반환
    public MenuDAO exec(UUID menuId) {
        return menuRepositoryJPA.findById(menuId).orElse(null);
    }

    // menuId와 boothId를 통해 원하는 DAO 찾아서 반환
    public MenuDAO exec(UUID menuId, UUID boothId) {
        return menuRepositoryJPA.findByMenuIdAndBoothId(menuId, boothId);
    }
}
