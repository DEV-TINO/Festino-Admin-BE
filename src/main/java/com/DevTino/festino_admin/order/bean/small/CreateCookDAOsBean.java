package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        // 메뉴 정보 받기
        List<Map<String, Object>> menuList = orderDAO.getMenuInfo();

        // menuList에서 하나씩 꺼내서
        for (Map<String, Object> menu : menuList){

            // 메뉴 정보로 Cook DAO 생성
            CookDAO cookDAO = createCookDAOBean.exec(menu, orderDAO);

            // 생성한 Cook DAO 저장
            saveCookDAOBean.exec(cookDAO);

        }

    }

}
