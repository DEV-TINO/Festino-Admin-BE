package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseOrderNowGetDTO {

    List<ResponseOrderWaitDepositGetDTO> waitDepositList;
    List<ResponseOrderCookingGetDTO> cookingList;
    List<ResponseOrderFinishGetDTO> finishList;

}
