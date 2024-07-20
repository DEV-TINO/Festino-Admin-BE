package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.menu.bean.small.GetMenusDAOBean;
import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.bean.small.CreateOrderStatisticGetDTOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderStatisticGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderStatisticBean {

    GetMenusDAOBean getMenusDAOBean;
    CreateOrderStatisticGetDTOBean createOrderStatisticGetDTOBean;

    @Autowired
    public GetOrderStatisticBean(GetMenusDAOBean getMenusDAOBean, CreateOrderStatisticGetDTOBean createOrderStatisticGetDTOBean){
        this.getMenusDAOBean = getMenusDAOBean;
        this.createOrderStatisticGetDTOBean = createOrderStatisticGetDTOBean;
    }



    // 주문 통계 조회
    public ResponseOrderStatisticGetDTO exec(UUID boothId, Integer date){

        // boothId로 해당 부스의 메뉴 검색
        List<MenuDAO> menuDAOList = getMenusDAOBean.exec(boothId);
        if (menuDAOList.size() == 0) return null;

        // 메뉴별 통계와 총매출 계산 -> DTO 생성해 반환
        return createOrderStatisticGetDTOBean.exec(date, menuDAOList);

    }

}
