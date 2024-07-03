package com.DevTino.festino_admin.menu.service;

import com.DevTino.festino_admin.menu.bean.DeleteMenuBean;
import com.DevTino.festino_admin.menu.bean.GetMenuBean;
import com.DevTino.festino_admin.menu.bean.SaveMenuBean;
import com.DevTino.festino_admin.menu.bean.UpdateMenuBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuDeleteDTO;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSaveDTO;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuUpdateDTO;
import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenuGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuService {
    SaveMenuBean saveMenuBean;
    UpdateMenuBean updateMenuBean;
    DeleteMenuBean deleteMenuBean;
    GetMenuBean getMenuBean;

    @Autowired
    public MenuService(SaveMenuBean saveMenuBean, UpdateMenuBean updateMenuBean, DeleteMenuBean deleteMenuBean, GetMenuBean getMenuBean) {
        this.saveMenuBean = saveMenuBean;
        this.updateMenuBean = updateMenuBean;
        this.deleteMenuBean = deleteMenuBean;
        this.getMenuBean = getMenuBean;
    }

    // 메뉴 저장
    public UUID saveMenu(RequestMenuSaveDTO requestMenuSaveDTO) {
        return saveMenuBean.exec(requestMenuSaveDTO);
    }

    // 메뉴 수정
    public UUID updateMenu(RequestMenuUpdateDTO requestMenuUpdateDTO) {
        return updateMenuBean.exec(requestMenuUpdateDTO);
    }

    // 메뉴 삭제
    public boolean deleteMenu(RequestMenuDeleteDTO requestMenuDeleteDTO) {
        return deleteMenuBean.exec(requestMenuDeleteDTO);
    }

    // 메뉴 조회
    public ResponseMenuGetDTO getMenu(UUID menuId) {
        return getMenuBean.exec(menuId);
    }
}
