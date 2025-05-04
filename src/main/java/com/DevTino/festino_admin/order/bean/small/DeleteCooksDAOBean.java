package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.CookRepository;
import com.DevTino.festino_admin.order.repository.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class DeleteCooksDAOBean {

    private final Map<String, CookRepository> cookRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public DeleteCooksDAOBean(Map<String, CookRepository> cookRepositoryMap, BoothNameResolver boothNameResolver){
        this.cookRepositoryMap = cookRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // CookDAO 리스트 삭제
    public void exec(UUID boothId, List<CookDTO> cookDTOList){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // 조리 리스트 삭제
        cookRepository.deleteAll(cookDTOList);

    }
}
