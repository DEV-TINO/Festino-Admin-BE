package com.DevTino.festino_admin.menu.bean;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.menu.bean.small.CreateMenuSoldOutDTOBean;
import com.DevTino.festino_admin.menu.bean.small.GetMenuDAOBean;
import com.DevTino.festino_admin.menu.bean.small.SaveMenuDAOBean;
import com.DevTino.festino_admin.menu.domain.DTO.RequestMenuSoldOutUpdateDTO;
import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenuSoldOutUpdateDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMenuSoldOutBean {
    GetMenuDAOBean getMenuDAOBean;
    CreateMenuSoldOutDTOBean createMenuSoldOutDTOBean;
    SaveMenuDAOBean saveMenuDAOBean;

    @Autowired
    public UpdateMenuSoldOutBean(GetMenuDAOBean getMenuDAOBean, CreateMenuSoldOutDTOBean createMenuSoldOutDTOBean, SaveMenuDAOBean saveMenuDAOBean) {
        this.getMenuDAOBean = getMenuDAOBean;
        this.createMenuSoldOutDTOBean = createMenuSoldOutDTOBean;
        this.saveMenuDAOBean = saveMenuDAOBean;
    }

    // 메뉴 품절 여부 수정
    public ResponseMenuSoldOutUpdateDTO exec(RequestMenuSoldOutUpdateDTO requestMenuSoldOutUpdateDTO) {
        // menuId와 boothId 통해 원하는 객체(DAO) 찾기
        MenuDAO menuDAO = getMenuDAOBean.exec(requestMenuSoldOutUpdateDTO.getMenuId(), requestMenuSoldOutUpdateDTO.getBoothId());

        // 메뉴 품절 여부와 입력값이 다른 경우 예외 발생
        if(requestMenuSoldOutUpdateDTO.getIsSoldOut() != menuDAO.getIsSoldOut()) throw new ServiceException(ExceptionEnum.STATUS_MISMATCH);

        // DAO 품절 여부 확인 후 수정
        menuDAO.setIsSoldOut(!menuDAO.getIsSoldOut());

        // 수정된 DAO 저장
        saveMenuDAOBean.exec(menuDAO);

        // DTO 생성해서 반환
        return createMenuSoldOutDTOBean.exec(menuDAO);
    }
}
