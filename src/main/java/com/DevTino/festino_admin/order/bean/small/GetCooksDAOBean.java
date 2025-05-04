package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.*;
import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import com.DevTino.festino_admin.order.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GetCooksDAOBean {

    private final Map<String, CookRepository> cookRepositoryMap;
    BoothNameResolver boothNameResolver;

    @Autowired
    public GetCooksDAOBean(Map<String, CookRepository> cookRepositoryMap, BoothNameResolver boothNameResolver){
        this.cookRepositoryMap = cookRepositoryMap;
        this.boothNameResolver = boothNameResolver;
    }



    // orderId에 해당하는 Cook 전체 조회
    public List<CookDTO> exec(UUID boothId, UUID orderId){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // orderId로 CookDAO 리스트 조회
        List<AbstractCookDAO> cookDAOList = cookRepository.findAllByOrderId(orderId);
        if(cookDAOList.isEmpty()) return new ArrayList<>();

        // CookDAO 리스트를 CookDTO 리스트로 변환해 반환
        List<CookDTO> cookDTOList = new ArrayList<>();
        for (AbstractCookDAO dao : cookDAOList) { cookDTOList.add(CookDTO.fromAbstractCookDAO(dao)); }
        return cookDTOList;

    }


    // menuId, isFinish, date로 Cook 오래된순 전체 조회
    public List<CookDTO> exec(UUID boothId, UUID menuId, Boolean isFinish, Integer date){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // orderId로 CookDAO 리스트 조회
        List<AbstractCookDAO> cookDAOList = cookRepository.findByMenuIdAndIsFinishAndDateOrderByCreateAtAsc(menuId, isFinish, date);
        if(cookDAOList.isEmpty()) return new ArrayList<>();

        // CookDAO 리스트를 CookDTO 리스트로 변환해 반환
        List<CookDTO> cookDTOList = new ArrayList<>();
        for (AbstractCookDAO dao : cookDAOList) { cookDTOList.add(CookDTO.fromAbstractCookDAO(dao)); }
        return cookDTOList;

    }



    // menuId, date, isFinish, isService로 Cook 전체 조회
    public List<CookDTO> exec(UUID boothId, UUID menuId, Integer date, Boolean isFinish, Boolean isService){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // orderId로 CookDAO 리스트 조회
        List<AbstractCookDAO> cookDAOList = cookRepository.findByMenuIdAndDateAndIsFinishAndIsService(menuId, date, isFinish, isService);
        if(cookDAOList.isEmpty()) return new ArrayList<>();

        // CookDAO 리스트를 CookDTO 리스트로 변환해 반환
        List<CookDTO> cookDTOList = new ArrayList<>();
        for (AbstractCookDAO dao : cookDAOList) { cookDTOList.add(CookDTO.fromAbstractCookDAO(dao)); }
        return cookDTOList;

    }

    // menuId, date, isFinish 로 Cook 전체 조회
    public List<CookDTO> exec(UUID boothId, UUID menuId, Integer date, Boolean isFinish){

        // boothId로 부스 이름 찾아서
        String boothName = boothNameResolver.execCook(boothId);

        // Map에서 해당 부스의 Repository 꺼내기
        CookRepository cookRepository = cookRepositoryMap.get(boothName);

        // orderId로 CookDAO 리스트 조회
        List<AbstractCookDAO> cookDAOList = cookRepository.findByMenuIdAndDateAndIsFinish(menuId, date, isFinish);
        if(cookDAOList.isEmpty()) return new ArrayList<>();

        // CookDAO 리스트를 CookDTO 리스트로 변환해 반환
        List<CookDTO> cookDTOList = new ArrayList<>();
        for (AbstractCookDAO dao : cookDAOList) { cookDTOList.add(CookDTO.fromAbstractCookDAO(dao)); }
        return cookDTOList;

    }

}
