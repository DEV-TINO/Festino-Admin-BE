package com.DevTino.festino_admin.booth.bean;

import com.DevTino.festino_admin.booth.bean.small.CreateFoodBoothOpenDTOBean;
import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.SaveFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothOpenUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.RequestFoodBoothUpdateDTO;
import com.DevTino.festino_admin.booth.domain.DTO.ResponseFoodBoothOpenGetDTO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateFoodBoothBean {
    GetFoodBoothDAOBean getFoodBoothDAOBean;
    SaveFoodBoothDAOBean saveFoodBoothDAOBean;
    CreateFoodBoothOpenDTOBean createFoodBoothOpenDTOBean;

    @Autowired
    public UpdateFoodBoothBean(GetFoodBoothDAOBean getFoodBoothDAOBean, SaveFoodBoothDAOBean saveFoodBoothDAOBean, CreateFoodBoothOpenDTOBean createFoodBoothOpenDTOBean) {
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
        this.saveFoodBoothDAOBean = saveFoodBoothDAOBean;
        this.createFoodBoothOpenDTOBean = createFoodBoothOpenDTOBean;
    }

    // 푸드트럭 수정
    public UUID exec(RequestFoodBoothUpdateDTO requestFoodBoothUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(requestFoodBoothUpdateDTO.getBoothId());
        if(foodBoothDAO == null) return null;

        // DAO 수정
        foodBoothDAO.setBoothName(requestFoodBoothUpdateDTO.getBoothName());
        foodBoothDAO.setBoothIntro(requestFoodBoothUpdateDTO.getBoothIntro());
        foodBoothDAO.setBoothImage(requestFoodBoothUpdateDTO.getBoothImage());
        foodBoothDAO.setAdminName(requestFoodBoothUpdateDTO.getAdminName());
        foodBoothDAO.setAdminCategory(requestFoodBoothUpdateDTO.getAdminCategory());
        foodBoothDAO.setOpenTime(requestFoodBoothUpdateDTO.getOpenTime());
        foodBoothDAO.setCloseTime(requestFoodBoothUpdateDTO.getCloseTime());
        foodBoothDAO.setLocation(requestFoodBoothUpdateDTO.getLocation());
        foodBoothDAO.setIsOpen(requestFoodBoothUpdateDTO.getIsOpen());

        foodBoothDAO.setUpdateAt(LocalDateTime.now());

        // 수정된 DAO 저장
        saveFoodBoothDAOBean.exec(foodBoothDAO);

        // 키값 반환
        return foodBoothDAO.getBoothId();
    }

    // 푸드트럭 운영 중 여부 수정
    public ResponseFoodBoothOpenGetDTO exec(RequestFoodBoothOpenUpdateDTO requestFoodBoothOpenUpdateDTO) {

        // 부스 아이디를 통해 원하는 객체(DAO) 찾기
        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(requestFoodBoothOpenUpdateDTO.getBoothId());
        if(foodBoothDAO == null) return null;

        // DAO 운영 중 여부 수정
        foodBoothDAO.setIsOpen(!foodBoothDAO.getIsOpen());

        // 수정된 DAO 저장
        saveFoodBoothDAOBean.exec(foodBoothDAO);

        // DTO 생성해서 반환
        return createFoodBoothOpenDTOBean.exec(foodBoothDAO);
    }
}
