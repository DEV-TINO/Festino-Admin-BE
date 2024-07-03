package com.DevTino.festino_admin.menu.service;

import com.DevTino.festino_admin.menu.bean.SaveMenuBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuService {
    SaveMenuBean saveMenuBean;

    @Autowired
    public MenuService(SaveMenuBean saveMenuBean) {
        this.saveMenuBean = saveMenuBean;
    }

    // 메뉴 저장
    public UUID saveMenu(RequestMenuSaveDTO requestMenuSaveDTO) {
        return saveMenuBean.exec(requestMenuSaveDTO);
    }
}
