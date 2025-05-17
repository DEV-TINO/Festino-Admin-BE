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
public class GetMenuDAOBean {
    MenuRepositoryJPA menuRepositoryJPA;

    @Autowired
    public GetMenuDAOBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    // menuId를 통해 원하는 DAO 찾아서 반환
    public MenuDAO exec(UUID menuId) {

        MenuDAO dao = menuRepositoryJPA.findById(menuId).orElse(null);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }

    // menuId와 boothId를 통해 원하는 DAO 찾아서 반환
    public MenuDAO exec(UUID menuId, UUID boothId) {

        MenuDAO dao = menuRepositoryJPA.findByMenuIdAndBoothId(menuId, boothId);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;

    }
}
