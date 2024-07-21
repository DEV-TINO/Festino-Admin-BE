package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCookingGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateOrderCookingGetDTOsBean {

    CreateOrderCookingGetDTOBean createOrderCookingGetDTOBean;

    @Autowired
    public CreateOrderCookingGetDTOsBean(CreateOrderCookingGetDTOBean createOrderCookingGetDTOBean){
        this.createOrderCookingGetDTOBean = createOrderCookingGetDTOBean;
    }



    // 메뉴 한 개당 하나의 DTO를 생성, DTO 리스트를 만들어 반환
    public List<ResponseOrderCookingGetDTO> exec(List<MenuDAO> menuDAOList){

        // DTO 리스트 생성
        List<ResponseOrderCookingGetDTO> orderCookingGetDTOList = new ArrayList<>();
        
        // MenuDAOList에서 Menu DAO 하나씩 꺼내서
        for (MenuDAO menuDAO : menuDAOList){
            
            // 메뉴 한 개당 하나의 DTO 생성, DTO 리스트에 삽입
            orderCookingGetDTOList.add(createOrderCookingGetDTOBean.exec(menuDAO));

        }

        // 생성된 DTO 리스트 반환
        return orderCookingGetDTOList;

    }

}
