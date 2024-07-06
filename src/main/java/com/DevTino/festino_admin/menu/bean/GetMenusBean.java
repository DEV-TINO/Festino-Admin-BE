package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.menu.bean.small.CreateMenusDTOBean;
import com.DevTino.festino_admin.menu.bean.small.GetMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenusGetDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetMenusBean {
    GetMenuDAOBean getMenuDAOBean;
    CreateMenusDTOBean createMenusDTOBean;

    @Autowired
    public GetMenusBean(GetMenuDAOBean getMenuDAOBean, CreateMenusDTOBean createMenusDTOBean) {
        this.getMenuDAOBean = getMenuDAOBean;
        this.createMenusDTOBean = createMenusDTOBean;
    }

    // 메뉴 전체 조회
    public List<ResponseMenusGetDTO> exec(UUID boothId) {
        // boothId를 통해 원하는 부스 메뉴 전체 DAO 찾기
        List<MenuDAO> menuDAOList = getMenuDAOBean.exec(boothId, 1);
        if(menuDAOList.isEmpty()) return null;

        // DAO 리스트를 DTO로 바꿔서 반환
        return createMenusDTOBean.exec(menuDAOList);
    }
}
