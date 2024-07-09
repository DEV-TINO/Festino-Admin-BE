package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenuGetDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMenusDTOBean {
    CreateMenuDTOBean createMenuDTOBean;

    @Autowired
    public CreateMenusDTOBean(CreateMenuDTOBean createMenuDTOBean) {
        this.createMenuDTOBean = createMenuDTOBean;
    }

    // 메뉴 DTO 리스트 생성해서 반환
    public List<ResponseMenuGetDTO> exec(List<MenuDAO> menuDAOList) {
        // DTO 리스트 생성
        List<ResponseMenuGetDTO> responseMenusGetDTOList = new ArrayList<>();

        // for문을 이용해 DAO를 하나씩 꺼내 DTO에 삽입
        for(MenuDAO menuDAO : menuDAOList) {
            // DTO 생성
            ResponseMenuGetDTO responseMenuGetDTO = createMenuDTOBean.exec(menuDAO);

            // DTO 리스트에 각 DTO ADD
            responseMenusGetDTOList.add(responseMenuGetDTO);
        }

        // DTO 리스트 반환
        return responseMenusGetDTOList;
    }
}
