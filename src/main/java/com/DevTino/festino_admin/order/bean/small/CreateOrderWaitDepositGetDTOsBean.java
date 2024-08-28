package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateOrderWaitDepositGetDTOsBean {

    CreateOrderWaitDepositGetDTOBean createOrderWaitDepositGetDTOBean;

    @Autowired
    public CreateOrderWaitDepositGetDTOsBean(CreateOrderWaitDepositGetDTOBean createOrderWaitDepositGetDTOBean){
        this.createOrderWaitDepositGetDTOBean = createOrderWaitDepositGetDTOBean;
    }



    // DAO 리스트를 DTO 리스트로 변환
    public List<ResponseOrderWaitDepositGetDTO> exec(List<OrderDTO> dtoList){

        // 반환할 DTO 리스트 생성
        List<ResponseOrderWaitDepositGetDTO> responseOrderWaitDepositGetDTOList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDTO orderDTO : dtoList){

            responseOrderWaitDepositGetDTOList.add(createOrderWaitDepositGetDTOBean.exec(orderDTO));

        }
        
        // DTO 리스트 리턴
        return responseOrderWaitDepositGetDTOList;

    }
    
}
