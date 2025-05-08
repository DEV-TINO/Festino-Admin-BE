package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.menu.domain.MenuDAO;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCookingGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CreateOrderCookingGetDTOBean {

    GetCooksDAOBean getCooksDAOBean;

    @Autowired
    public CreateOrderCookingGetDTOBean(GetCooksDAOBean getCooksDAOBean) {
        this.getCooksDAOBean = getCooksDAOBean;
    }

    // DTO 생성해 반환
    public ResponseOrderCookingGetDTO exec(UUID boothId, MenuDAO menuDAO, Integer date){

        // 각 메뉴에 해당하는 조리(Cook) 정보를 담을 List 생성
        List<Map<String, Object>> cooks = new ArrayList<>();

        // menuId로 해당 학과에 맞는 날짜의 조리중인 Cook 오래된순 전체 조회
        List<CookDTO> cookDTOList = getCooksDAOBean.exec(boothId, menuDAO.getMenuId(), false, date);
        
        // 메뉴가 삭제된 상태이고, 메뉴로 조회한 CookList도 비어 있다면 null 리턴
        if (menuDAO.getIsDeleted() && cookDTOList.isEmpty()) return null;

        // 주문한 테이블 총합, 남은 개수 총합
        Integer tableCount = 0;
        Integer totalRemainCount = 0;

        // 조회한 CookDAO 리스트로 조리(Cook) 정보 얻기
        for (CookDTO cookDTO : cookDTOList){

            // CookDAO의 정보로 Map 생성
            Map<String, Object> map = new HashMap<>();
            map.put("cookId", cookDTO.getCookId());
            map.put("tableNum", cookDTO.getTableNum());
            map.put("totalCount", cookDTO.getTotalCount());
            map.put("servedCount", cookDTO.getServedCount());
            map.put("orderId", cookDTO.getOrderId());

            // cooks에 삽입
            cooks.add(map);

            // tableCount와 totalRemainCount 적재
            tableCount ++;
            totalRemainCount += (cookDTO.getTotalCount() - cookDTO.getServedCount());

        }

        // DTO 생성해 반환
        return ResponseOrderCookingGetDTO.builder()
                .menuId(menuDAO.getMenuId())
                .menuName(menuDAO.getMenuName())
                .tableCount(tableCount)
                .totalRemainCount(totalRemainCount)
                .cookList(cooks)
                .build();

    }

}
