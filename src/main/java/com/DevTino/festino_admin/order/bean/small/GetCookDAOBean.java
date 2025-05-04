package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.CookRepository;
import com.DevTino.festino_admin.order.repository.OrderRepository;
import com.DevTino.festino_admin.order.repository.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GetCookDAOBean {

    private final Map<String, CookRepository> cookRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetCookDAOBean(Map<String, CookRepository> cookRepositoryMap, BoothNameResolver boothNameResolver){
        this.cookRepositoryMap = cookRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // cookId로 DAO 찾아서 반환하는 메서드
    public CookDTO exec(UUID boothId, UUID cookId){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // cookId로 CookDAO 조회, CookDTO로 변환해 반환
        AbstractCookDAO dao = cookRepository.findById(cookId);
        if (dao == null) return null;
        return CookDTO.fromAbstractCookDAO(dao);

    }

}
