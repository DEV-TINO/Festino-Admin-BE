package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMenuDAOBean {
    MenuRepository menuRepository;

    @Autowired
    public SaveMenuDAOBean(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // 메뉴 DAO를 DB에 저장
    public void exec(MenuDAO menuDAO) {
        menuRepository.save(menuDAO);
    }
}
