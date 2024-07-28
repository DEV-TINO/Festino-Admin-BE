package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.menu.bean.small.GetMenuDAOBean;
import com.DevTino.festino_admin.menu.bean.small.SaveMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuUpdateDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateMenuBean {
    GetMenuDAOBean getMenuDAOBean;
    SaveMenuDAOBean saveMenuDAOBean;

    @Autowired
    public UpdateMenuBean(GetMenuDAOBean getMenuDAOBean, SaveMenuDAOBean saveMenuDAOBean) {
        this.getMenuDAOBean = getMenuDAOBean;
        this.saveMenuDAOBean = saveMenuDAOBean;
    }

    // 메뉴 수정
    public UUID exec(RequestMenuUpdateDTO requestMenuUpdateDTO) {
        // menuId를 통해 원하는 객체(DAO) 찾기
        MenuDAO menuDAO = getMenuDAOBean.exec(requestMenuUpdateDTO.getMenuId(), requestMenuUpdateDTO.getBoothId());
        if(menuDAO == null) return null;

        // 메뉴 이미지 넣지 않았을때 빈값으로 넣어주는 예외처리
        String image = "";
        if (requestMenuUpdateDTO.getMenuImage() != null)
            image = requestMenuUpdateDTO.getMenuImage();

        // 찾은 DAO 수정
        menuDAO.setBoothId(requestMenuUpdateDTO.getBoothId());
        menuDAO.setMenuImage(image);
        menuDAO.setMenuDescription(requestMenuUpdateDTO.getMenuDescription());
        menuDAO.setMenuName(requestMenuUpdateDTO.getMenuName());
        menuDAO.setMenuPrice(requestMenuUpdateDTO.getMenuPrice());
        menuDAO.setIsSoldOut(requestMenuUpdateDTO.getIsSoldOut());

        menuDAO.setMenuType(requestMenuUpdateDTO.getMenuType());

        menuDAO.setUpdateAt(DateTimeUtils.nowZone());

        // 수정한 DAO 저장
        saveMenuDAOBean.exec(menuDAO);

        // 키값 반환
        return menuDAO.getMenuId();
    }
}
