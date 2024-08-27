package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.MenuInfoDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CreateCookDAOsBean {


    CreateCookDAOBean createCookDAOBean;
    SaveCookDAOBean saveCookDAOBean;

    @Autowired
    public CreateCookDAOsBean(CreateCookDAOBean createCookDAOBean, SaveCookDAOBean saveCookDAOBean){
        this.createCookDAOBean = createCookDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
    }



    // orderDAO의 메뉴 정보에 따라 CookDAO 생성
    public void exec(OrderDAO orderDAO){

        // Cook DAO 리스트 생성
        List<CookDAO> cookDAOList = new ArrayList<>();

        try {

            // ObjectMapper 설정
            ObjectMapper objectMapper = new ObjectMapper();
            List<MenuInfoDTO> menuList = new ArrayList<>();
            String menuListString = null;

            // ObjectMapper를 이용해 menuInfo를 String 타입으로 변환
            menuListString = objectMapper.writeValueAsString(orderDAO.getMenuInfo());

            // ObjectMapper를 이용해 String 타입으로 변환된 menuInfo를 List<MenuInfo>로 매핑
            menuList = objectMapper.readValue(menuListString, new TypeReference<List<MenuInfoDTO>>() {});
            
            // menuList에서 하나씩 꺼내서
            for (MenuInfoDTO menu : menuList) {

                // 메뉴 정보로 Cook DAO 생성
                CookDAO cookDAO = createCookDAOBean.exec(menu, orderDAO);

                // 생성한 Cook DAO 리스트에 적재
                cookDAOList.add(cookDAO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cook DAO 리스트 저장
        saveCookDAOBean.exec(cookDAOList);

    }

}
