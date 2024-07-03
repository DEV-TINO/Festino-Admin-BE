package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteMenuDAOBean {
    MenuRepository menuRepository;

    @Autowired
    public DeleteMenuDAOBean(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // DAO 삭제
    public void exec(MenuDAO menuDAO) {
        menuRepository.delete(menuDAO);
    }
}
