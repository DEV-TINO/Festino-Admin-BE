package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.menu.repository.MenuRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMenuDAOBean {
    MenuRepositoryJPA menuRepositoryJPA;

    @Autowired
    public SaveMenuDAOBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    // 메뉴 DAO를 DB에 저장
    public void exec(MenuDAO menuDAO) {
        menuRepositoryJPA.save(menuDAO);
    }
}
