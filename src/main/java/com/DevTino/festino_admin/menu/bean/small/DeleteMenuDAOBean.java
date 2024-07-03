package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.menu.repository.MenuRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteMenuDAOBean {
    MenuRepositoryJPA menuRepositoryJPA;

    @Autowired
    public DeleteMenuDAOBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    // DAO 삭제
    public void exec(MenuDAO menuDAO) {
        menuRepositoryJPA.delete(menuDAO);
    }
}
