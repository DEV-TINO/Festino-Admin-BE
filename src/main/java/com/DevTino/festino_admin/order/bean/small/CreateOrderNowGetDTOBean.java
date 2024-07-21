package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCookingGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderNowGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderNowGetDTOBean {

    // DTO 생성해 반환
    public ResponseOrderNowGetDTO exec(List<ResponseOrderWaitDepositGetDTO> waitDepositList, List<ResponseOrderCookingGetDTO> cookingList, List<ResponseOrderFinishGetDTO> finishList){

        return ResponseOrderNowGetDTO.builder()
                .waitDepositList(waitDepositList)
                .cookingList(cookingList)
                .finishList(finishList)
                .build();

    }
}
