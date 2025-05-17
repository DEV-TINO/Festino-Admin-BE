package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.menu.bean.small.CreateMenuDTOBean;
import com.DevTino.festino_admin.menu.bean.small.GetMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenuGetDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetMenuBean {
    GetMenuDAOBean getMenuDAOBean;
    CreateMenuDTOBean createMenuDTOBean;

    @Autowired
    public GetMenuBean(GetMenuDAOBean getMenuDAOBean, CreateMenuDTOBean createMenuDTOBean) {
        this.getMenuDAOBean = getMenuDAOBean;
        this.createMenuDTOBean = createMenuDTOBean;
    }

    // 메뉴 조회
    public ResponseMenuGetDTO exec(UUID menuId) {
        // menuId를 통해 원하는 객체(DAO 찾기)
        MenuDAO menuDAO = getMenuDAOBean.exec(menuId);

        // DTO 생성해서 반환
        return createMenuDTOBean.exec(menuDAO);
    }
}
