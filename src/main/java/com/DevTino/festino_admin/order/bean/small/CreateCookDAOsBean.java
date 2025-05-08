package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.domain.DTO.MenuInfoDTO;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
    public void exec(UUID boothId, OrderDTO orderDTO){

        // Cook DAO 리스트 생성
        List<CookDTO> cookDTOList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> list = new ArrayList<>();
        String newMenuList = null;
        try {
            // MenuInfo로 String으로 변환
            newMenuList = objectMapper.writeValueAsString(orderDTO.getMenuInfo());

            // String으로 변환한 MenuInfo를 objectMapper를 통해 List의 Map형태로 바꿈
            list = objectMapper.readValue(newMenuList, new TypeReference<List<Map<String, Object>>>() {});

            // menuList에서 하나씩 꺼내서
            for (Map<String, Object> menu : list){

                MenuInfoDTO menuInfoDTO = objectMapper.convertValue(menu, MenuInfoDTO.class);

                // 메뉴 정보로 Cook DAO 생성
                CookDTO cookDTO = createCookDAOBean.exec(menuInfoDTO, orderDTO);

                // 생성한 Cook DAO 리스트에 적재
                cookDTOList.add(cookDTO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Cook DAO 리스트 저장
        saveCookDAOBean.exec(boothId, cookDTOList);

    }

}
