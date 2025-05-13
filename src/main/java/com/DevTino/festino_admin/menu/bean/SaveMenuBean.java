package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.menu.bean.small.CreateMenuDAOBean;
import com.DevTino.festino_admin.menu.bean.small.SaveMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSaveDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveMenuBean {
    CreateMenuDAOBean createMenuDAOBean;
    SaveMenuDAOBean saveMenuDAOBean;

    @Autowired
    public SaveMenuBean(CreateMenuDAOBean createMenuDAOBean, SaveMenuDAOBean saveMenuDAOBean) {
        this.createMenuDAOBean = createMenuDAOBean;
        this.saveMenuDAOBean = saveMenuDAOBean;
    }

    // 메뉴 저장
    public UUID exec(RequestMenuSaveDTO requestMenuSaveDTO) {

        // 메뉴 DAO 생성
        MenuDAO menuDAO = createMenuDAOBean.exec(requestMenuSaveDTO);

        // 메뉴 저장
        saveMenuDAOBean.exec(menuDAO);

        // 키값 반환
        return menuDAO.getMenuId();
    }
}
