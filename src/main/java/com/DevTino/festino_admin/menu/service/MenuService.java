package com.DevTino.festino_admin.menu.service;

import com.DevTino.festino_admin.menu.bean.*;
import com.DevTino.festino_admin.menu.domain.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {
    SaveMenuBean saveMenuBean;
    UpdateMenuBean updateMenuBean;
    DeleteMenuBean deleteMenuBean;
    GetMenuBean getMenuBean;
    GetMenusBean getMenusBean;

    @Autowired
    public MenuService(SaveMenuBean saveMenuBean, UpdateMenuBean updateMenuBean, DeleteMenuBean deleteMenuBean, GetMenuBean getMenuBean, GetMenusBean getMenusBean) {
        this.saveMenuBean = saveMenuBean;
        this.updateMenuBean = updateMenuBean;
        this.deleteMenuBean = deleteMenuBean;
        this.getMenuBean = getMenuBean;
        this.getMenusBean = getMenusBean;
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

    // 메뉴 전체조회
    public List<ResponseMenuGetDTO> getMenuAll(UUID boothId) {
        return getMenusBean.exec(boothId);
    }
}
