package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.MenuInfoDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderServiceSaveDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateOrderServiceSaveDTOBean {

    // 저장할 DTO의 가격을 모두 0으로 수정
    public RequestOrderServiceSaveDTO exec(RequestOrderServiceSaveDTO requestOrderServiceSaveDTO) {

        // DTO의 menuInfo 리스트 받아서
        List<MenuInfoDTO> menuInfoDTOList = requestOrderServiceSaveDTO.getMenuInfo();
        
        // 모든 메뉴의 가격을 0으로 설정
        for (MenuInfoDTO menuInfoDTO : menuInfoDTOList) { menuInfoDTO.setMenuPrice(0); }

        // 전체 가격을 0으로 설정
        requestOrderServiceSaveDTO.setTotalPrice(0);

        // 수정된 DTO 반환
        return requestOrderServiceSaveDTO;
        
    }
    
}
