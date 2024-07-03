package com.DevTino.festino_admin.menu.bean.small;

import com.DevTino.festino_admin.menu.domain.DTO.ResponseMenusGetDTO;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMenusDTOBean {

    // 메뉴 DTO 리스트 생성해서 반환
    public List<ResponseMenusGetDTO> exec(List<MenuDAO> menuDAOList) {
        // DTO 리스트 생성
        List<ResponseMenusGetDTO> responseMenusGetDTOList = new ArrayList<>();

        // for문을 이용해 DAO를 하나씩 꺼내 DTO에 삽입
        for(MenuDAO menuDAO : menuDAOList) {
            // DTO 생성
            ResponseMenusGetDTO responseMenusGetDTO = ResponseMenusGetDTO.builder()
                    .menuId(menuDAO.getMenuId())
                    .menuName(menuDAO.getMenuName())
                    .menuImage(menuDAO.getMenuImage())
                    .menuDescription(menuDAO.getMenuDescription())
                    .menuPrice(menuDAO.getMenuPrice())
                    .isSoldOut(menuDAO.getIsSoldOut())
                    .build();

            // DTO 리스트에 각 DTO ADD
            responseMenusGetDTOList.add(responseMenusGetDTO);
        }

        // DTO 리스트 반환
        return responseMenusGetDTOList;
    }
}
