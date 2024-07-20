package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderStatisticGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateOrderStatisticGetDTOBean {

    GetCooksDAOBean getCooksDAOBean;

    @Autowired
    public CreateOrderStatisticGetDTOBean(GetCooksDAOBean getCooksDAOBean){
        this.getCooksDAOBean = getCooksDAOBean;
    }



    // DTO 생성해 반환
    public ResponseOrderStatisticGetDTO exec(Integer date, List<MenuDAO> menuDAOList){

        // 총매출 totalSale, 메뉴별 매출 정보를 저장할 리스트 menuSaleList
        Integer totalSale = 0;
        List<Map<String, Object>> menuSaleList = new ArrayList<>();

        // 메뉴별 매출 계산
        for (MenuDAO menuDAO : menuDAOList){

            // 메뉴의 총판매수량
            Integer menuCount = 0;

            // 메뉴 이름과 날짜(date)로 Cook 조회
            List<CookDAO> cookDAOList = getCooksDAOBean.exec(menuDAO.getMenuName(), date);

            // 조회한 Cook 리스트로 메뉴의 총판매수량 계산
            for (CookDAO cookDAO : cookDAOList){ menuCount += cookDAO.getTotalCount(); }

            // 메뉴의 매출 정보를 Map으로 생성
            Map<String, Object> map = new HashMap<>();
            map.put("menuName", menuDAO.getMenuName());
            map.put("menuCount", menuCount);
            map.put("menuSale", menuDAO.getMenuPrice() * menuCount);

            // 생성한 Map을 menuSaleList에 추가
            menuSaleList.add(map);

            // totalSale에 매출액 적재
            totalSale += menuDAO.getMenuPrice() * menuCount;

        }

        // DTO 생성해 반환
        return ResponseOrderStatisticGetDTO.builder()
                .totalSale(totalSale)
                .menuSaleList(menuSaleList)
                .build();

    }

}
