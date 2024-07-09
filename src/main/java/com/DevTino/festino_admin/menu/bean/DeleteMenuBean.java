package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.menu.bean.small.DeleteMenuDAOBean;
import com.DevTino.festino_admin.menu.bean.small.GetMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuDeleteDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteMenuBean {
    GetMenuDAOBean getMenuDAOBean;
    DeleteMenuDAOBean deleteMenuDAOBean;

    @Autowired
    public DeleteMenuBean(GetMenuDAOBean getMenuDAOBean, DeleteMenuDAOBean deleteMenuDAOBean) {
        this.getMenuDAOBean = getMenuDAOBean;
        this.deleteMenuDAOBean = deleteMenuDAOBean;
    }

    // 메뉴 삭제
    public boolean exec(RequestMenuDeleteDTO requestMenuDeleteDTO) {
        // menuId와 boothId를 통해 원하는 객체(DAO) 찾기
        MenuDAO menuDAO = getMenuDAOBean.exec(requestMenuDeleteDTO.getMenuId(), requestMenuDeleteDTO.getBoothId());
        if(menuDAO==null) return false;

        // 찾은 DAO 삭제
        deleteMenuDAOBean.exec(menuDAO);
        return true;
    }
}
