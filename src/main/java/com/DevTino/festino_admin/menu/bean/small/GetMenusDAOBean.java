package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
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


    // boothId로 메뉴 리스트 검색해 반환
    public List<MenuDAO> exec(UUID boothId) {

        List<MenuDAO> daoList = menuRepositoryJPA.findAllByBoothIdOrderByMenuIndexAsc(boothId);
        if (daoList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);

        return daoList;

    }

    // boothId, isDeleted로 MenuDAO 검색해 반환
    public List<MenuDAO> exec(UUID boothId, Boolean isDeleted) {
        return menuRepositoryJPA.findAllByBoothIdAndIsDeletedOrderByMenuIndexAsc(boothId, isDeleted);
    }
}
