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


    // boothId로 MenuDAO 검색해 반환
    public List<MenuDAO> exec(UUID boothId) {
        return menuRepositoryJPA.findAllByBoothIdOrderByMenuIndexAsc(boothId);
    }

    // boothId, isDeleted로 MenuDAO 검색해 반환
    public List<MenuDAO> exec(UUID boothId, Boolean isDeleted) {
        return menuRepositoryJPA.findAllByBoothIdAndIsDeletedOrderByMenuIndexAsc(boothId, isDeleted);
    }
}
