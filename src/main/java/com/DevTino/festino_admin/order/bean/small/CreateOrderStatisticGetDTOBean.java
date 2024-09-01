package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
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
    public ResponseOrderStatisticGetDTO exec(String adminName, Integer date, List<MenuDAO> menuDAOList, String type){

        // 총매출 totalSale, 메뉴별 매출 정보를 저장할 리스트 menuSaleList
        Integer totalSale = 0;
        List<Map<String, Object>> menuSaleList = new ArrayList<>();

        // 메뉴별 매출 계산
        for (MenuDAO menuDAO : menuDAOList){

            // 메뉴의 총판매수량
            Integer menuCount = 0;

            switch (type) {
                case "all" -> {
                    // 타입이 all일 때 메뉴 아이디와 날짜(date)로 완료된, 일반과 서비스가 포함된 Cook 조회
                    List<CookDTO> cookDTOList = getCooksDAOBean.exec(adminName, menuDAO.getMenuId(), date, true);

                    // 조회한 Cook 리스트로 메뉴의 총판매수량 계산
                    for (CookDTO cookDTO : cookDTOList){ menuCount += cookDTO.getTotalCount(); }
                }
                case "service" -> {
                    // 타입이 service일 때 메뉴 아이디와 날짜(date)로 완료된, 서비스인 Cook 조회
                    List<CookDTO> cookDTOList = getCooksDAOBean.exec(adminName, menuDAO.getMenuId(), date, true, true);

                    // 조회한 Cook 리스트로 메뉴의 총판매수량 계산
                    for (CookDTO cookDTO : cookDTOList){ menuCount += cookDTO.getTotalCount(); }
                }
                case "normal" -> {
                    // 타입이 normal일 때 메뉴 아이디와 날짜(date)로 완료된, 일반 Cook 조회
                    List<CookDTO> cookDTOList = getCooksDAOBean.exec(adminName, menuDAO.getMenuId(), date, true, false);

                    // 조회한 Cook 리스트로 메뉴의 총판매수량 계산
                    for (CookDTO cookDTO : cookDTOList){ menuCount += cookDTO.getTotalCount(); }
                }
                default -> {
                    return null;
                }
            }

            // 메뉴의 매출 정보를 Map으로 생성
            Map<String, Object> map = new HashMap<>();
            map.put("menuName", menuDAO.getMenuName());
            map.put("menuPrice", menuDAO.getMenuPrice());
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
