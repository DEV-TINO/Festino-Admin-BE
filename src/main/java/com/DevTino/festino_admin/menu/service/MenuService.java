package com.DevTino.festino_admin.menu.service;

import com.DevTino.festino_admin.menu.bean.SaveMenuBean;
import com.DevTino.festino_admin.menu.bean.UpdateMenuBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSaveDTO;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuService {
    SaveMenuBean saveMenuBean;
    UpdateMenuBean updateMenuBean;

    @Autowired
    public MenuService(SaveMenuBean saveMenuBean, UpdateMenuBean updateMenuBean) {
        this.saveMenuBean = saveMenuBean;
        this.updateMenuBean = updateMenuBean;
    }

    // 메뉴 저장
    public UUID saveMenu(RequestMenuSaveDTO requestMenuSaveDTO) {
        return saveMenuBean.exec(requestMenuSaveDTO);
    }

    // 메뉴 수정
    public UUID updateMenu(RequestMenuUpdateDTO requestMenuUpdateDTO) {
        return updateMenuBean.exec(requestMenuUpdateDTO);
    }
}
