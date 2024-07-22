package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.menu.bean.small.DeleteMenuDAOBean;
import com.DevTino.festino_admin.menu.bean.small.GetMenuDAOBean;
import com.DevTino.festino_admin.menu.bean.small.SaveMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuDeleteDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteMenuBean {
    GetMenuDAOBean getMenuDAOBean;
    SaveMenuDAOBean saveMenuDAOBean;

    @Autowired
    public DeleteMenuBean(GetMenuDAOBean getMenuDAOBean, SaveMenuDAOBean saveMenuDAOBean) {
        this.getMenuDAOBean = getMenuDAOBean;
        this.saveMenuDAOBean = saveMenuDAOBean;
    }

    // 메뉴 삭제
    public UUID exec(RequestMenuDeleteDTO requestMenuDeleteDTO) {
        // menuId와 boothId를 통해 원하는 객체(DAO) 찾기
        MenuDAO menuDAO = getMenuDAOBean.exec(requestMenuDeleteDTO.getMenuId(), requestMenuDeleteDTO.getBoothId());
        if(menuDAO==null) return null;

        // 메뉴 삭제 여부를 Boolean 을 통해 변경
        menuDAO.setIsDeleted(true);

        // 수정한 DAO 저장
        saveMenuDAOBean.exec(menuDAO);

        // 키값 반환
        return menuDAO.getMenuId();
    }
}
