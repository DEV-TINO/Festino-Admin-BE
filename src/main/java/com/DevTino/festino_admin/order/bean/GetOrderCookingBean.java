package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.menu.bean.small.GetMenusDAOBean;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.bean.small.CreateOrderCookingGetDTOsBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCookingGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderCookingBean {

    GetMenusDAOBean getMenusDAOBean;
    CreateOrderCookingGetDTOsBean createOrderCookingGetDTOsBean;

    @Autowired
    public GetOrderCookingBean(GetMenusDAOBean getMenusDAOBean, CreateOrderCookingGetDTOsBean createOrderCookingGetDTOsBean){
        this.getMenusDAOBean = getMenusDAOBean;
        this.createOrderCookingGetDTOsBean = createOrderCookingGetDTOsBean;
    }

    // 조리중 주문 조회
    public List<ResponseOrderCookingGetDTO> exec(UUID boothId){

        // boothId로 해당 부스의 메뉴 검색
        List<MenuDAO> menuDAOList = getMenusDAOBean.exec(boothId);
        if (menuDAOList.isEmpty()) return null;

        // 메뉴 정보를 활용해 DTO 리스트를 생성해 리턴
        return createOrderCookingGetDTOsBean.exec(menuDAOList);

    }

}