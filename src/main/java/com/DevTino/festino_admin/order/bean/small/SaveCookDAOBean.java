package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class SaveCookDAOBean {

    private final Map<String, CookRepository> cookRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public SaveCookDAOBean(Map<String, CookRepository> cookRepositoryMap, BoothNameResolver boothNameResolver){
        this.cookRepositoryMap = cookRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // 조리 DAO 저장
    public void exec(UUID boothId, CookDTO cookDTO){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // Cook 저장
        cookRepository.save(cookDTO);
                
    }

    // 조리 DAO 리스트 저장
    public void exec(UUID boothId, List<CookDTO> cookDTOList){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);
        
        // Cook 리스트 저장
        cookRepository.saveAll(cookDTOList);

    }

}
