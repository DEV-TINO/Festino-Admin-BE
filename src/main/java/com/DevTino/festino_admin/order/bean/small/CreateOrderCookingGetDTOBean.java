package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCookingGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateOrderCookingGetDTOBean {

    GetCooksDAOBean getCooksDAOBean;
    GetOrderDAOBean getOrderDAOBean;

    @Autowired
    public CreateOrderCookingGetDTOBean(GetCooksDAOBean getCooksDAOBean, GetOrderDAOBean getOrderDAOBean){
        this.getCooksDAOBean = getCooksDAOBean;
        this.getOrderDAOBean = getOrderDAOBean;
    }



    // DTO 생성해 반환
    public ResponseOrderCookingGetDTO exec(MenuDAO menuDAO){

        // 각 메뉴에 해당하는 조리(Cook) 정보를 담을 List 생성
        List<Map<String, Object>> cooks = new ArrayList<>();

        // menuName으로 조리중인 Cook 최신순 전체 조회
        List<CookDAO> cookDAOList = getCooksDAOBean.exec(menuDAO.getMenuName(), false);

        // 주문한 테이블 총합, 남은 개수 총합
        Integer tableCount = 0;
        Integer totalRemainCount = 0;

        // 조회한 CookDAO 리스트로 조리(Cook) 정보 얻기
        for (CookDAO cookDAO : cookDAOList){

            // CookDAO의 정보로 Map 생성
            Map<String, Object> map = new HashMap<>();
            map.put("cookId", cookDAO.getCookId());
            map.put("tableNum", getOrderDAOBean.exec(cookDAO.getOrderId()).getTableNum());
            map.put("totalCount", cookDAO.getTotalCount());
            map.put("servedCount", cookDAO.getServedCount());

            // cooks에 삽입
            cooks.add(map);

            // tableCount와 totalRemainCount 적재
            tableCount ++;
            totalRemainCount += (cookDAO.getTotalCount() - cookDAO.getServedCount());

        }

        // DTO 생성해 반환
        return ResponseOrderCookingGetDTO.builder()
                .menuId(menuDAO.getMenuId())
                .menuName(menuDAO.getMenuName())
                .tableCount(tableCount)
                .totalRemainCount(totalRemainCount)
                .cooks(cooks)
                .build();

    }

}
