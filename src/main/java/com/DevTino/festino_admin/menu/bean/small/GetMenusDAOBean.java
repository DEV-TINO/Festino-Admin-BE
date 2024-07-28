package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.menu.repository.MenuRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetMenusDAOBean {
    MenuRepositoryJPA menuRepositoryJPA;

    @Autowired
    public GetMenusDAOBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    // boothId를 통해 원하는 부스 전체 DAO 찾아서 반환
    public List<MenuDAO> exec(UUID boothId) {
        return menuRepositoryJPA.findAllByBoothIdAndIsDeletedOrderByMenuIndexAsc(boothId, false);
    }
}
